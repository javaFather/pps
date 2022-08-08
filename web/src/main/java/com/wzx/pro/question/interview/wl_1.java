package com.wzx.pro.question.interview;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wl_1 {
    private static List<List<Integer>> handle(int[] source,int target){
        if(source.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(source);
        List<List<Integer>> result = new ArrayList<>();
        int slowIndex = 0;
        int fastIndex = source.length-1;
        while (slowIndex<fastIndex){
            int sum = source[slowIndex]+source[fastIndex];
            if(sum==target){
                List<Integer> item = new ArrayList<>();
                item.add(source[slowIndex]);
                item.add(source[fastIndex]);
                while (source[slowIndex]==source[slowIndex+1]){
                    slowIndex++;
                }
                while (source[fastIndex]==source[fastIndex-1]){
                    fastIndex--;
                }
                result.add(item);
                slowIndex++;
                fastIndex--;
            }
            if(sum>target){
                fastIndex--;
            }
            if(sum<target){
                slowIndex++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,3,4,0,1,4,0,0,0,4,4,4,3};
        List<List<Integer>> handle = handle(nums, 4);
        System.out.println(JSON.toJSONString(handle));
    }



}
