package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class Q300 {
    public static List<Integer> solution(int[] array) {
        List<Integer> result = Lists.newArrayList();
        for(int j=0;j<array.length;j++){
            List<Integer> temp = Lists.newArrayList();
            for (int i = j; i < array.length; i++) {
                if (temp.isEmpty()) {
                    if(!result.isEmpty()){
                        if(result.get(0)<=array[j]){
                            break;
                        }
                    }
                    temp.add(array[j]);
                    continue;
                }
                if(temp.size()>1){
                    if(temp.get(temp.size()-1)<array[i]){
                        temp.add(array[i]);
                    }else if(temp.get(temp.size()-1)>array[i] && temp.get(temp.size()-2)<array[i]){
                        temp.set(temp.size()-1,array[i]);
                    }
                    continue;
                }
                if (temp.get(0) > array[i]) {
                    temp.set(0, array[i]);
                }else{
                    temp.add(array[i]);
                }
            }
            if (result.size()<temp.size()){
                result = temp;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = new int[]{10, 9, 5, 6, 2,3,4,6, 7, 101, 18};
        List<Integer> solution = solution(array);
        System.out.println(JSON.toJSONString(solution));
    }
}
