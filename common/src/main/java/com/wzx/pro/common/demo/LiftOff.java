package com.wzx.pro.common.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable {
    protected int countDown =10;
    private static int taskCount =0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    private String status(){
        return "#"+id+"("+(countDown>0?countDown:"liftoff")+")";
    }
    @Override
    public void run() {
        while (countDown-->0){
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        int a = 5;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        while(a-->0){
           executorService.execute(new LiftOff());
        }

    }
}
