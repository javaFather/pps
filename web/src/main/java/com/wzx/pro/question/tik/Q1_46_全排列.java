package com.wzx.pro.question.tik;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class Q1_46_全排列 {

    private static List<List<Integer>> result = Lists.newArrayList();

    private static List<List<Integer>> solution(int[] nums){
        back(nums,Lists.newArrayList(), Maps.newHashMap());
        return result;
    }

    private static void back(int[] nums, List<Integer> item, Map<Integer,Integer> map){
        if(nums.length==item.size()){
            result.add(Lists.newArrayList(item));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(i)){
                int num = nums[i];
                map.put(i,num);
                item.add(num);
                back(nums,item,map);
                map.remove(i);
                item.remove(item.size()-1);
            }


        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
    }
}
