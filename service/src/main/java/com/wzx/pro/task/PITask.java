package com.wzx.pro.task;

import java.util.concurrent.RecursiveTask;

public class PITask extends RecursiveTask<Double> {
    private final long begin;
    private final long end;
    private final long threshold; // 分割任务的临界值

    public PITask(long begin,long end,long threshold){
        this.begin = begin;
        this.end = end;
        this.threshold= threshold;
    }

    @Override
    protected Double compute() {
        if(end-begin<=threshold){
            int sign; // 符号，多项式中偶数位取 1，奇数位取 -1（位置从 0 开始）
            double result = 0.0;

            for(long i=begin;i<end;i++){
                sign = (i&1)==0?1:-1;
                result += sign/(i*2.0+1);
            }
            return result*4;
        }
        //分割任务
        long middle = (end+begin)/2;
        PITask left = new PITask(begin,middle,threshold);
        PITask right = new PITask(middle,end,threshold);
        left.fork();
        right.fork();
        double leftResult = left.join();
        double rightResult = right.join();
        return leftResult+rightResult;
    }
}
