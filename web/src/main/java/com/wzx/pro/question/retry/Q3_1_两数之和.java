package com.wzx.pro.question.retry;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class Q3_1_两数之和 {

    private static List<Integer> solution(int[] nums ,int target){
        Map<Integer,Integer> map = Maps.newHashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
            int aim = target-nums[i];
            Integer val = map.get(aim);
            if(val!=null){
                return Lists.newArrayList(val,i);
            }

        }


        return Lists.newArrayList();
    }

    public static void main(String[] args) {
        int[] nums ={2,7,11,15};
        List<Integer> solution = solution(nums, 19);
        System.out.println(JSON.toJSONString(solution));
    }
}
