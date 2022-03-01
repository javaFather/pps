package com.wzx.pro.question.compony;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class Q470_随机生成数 {

    private static int solution() {
        int min = rand7()-1;
        int max = rand7();
        int aim = min*max;
        if (aim>=4){
            return aim/4;
        }
       return solution();
    }

    private static int rand7(){
        int i = (int) (Math.random()*7)+1;
        return i;
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        while (list.size()<10){
            int i = solution();
            if(!list.contains(i)){
                list.add(i);
            }
        }
        System.out.println(JSON.toJSONString(list));
    }
}
