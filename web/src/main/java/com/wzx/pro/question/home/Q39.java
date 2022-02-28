package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class Q39 {

    private static List<List<Integer>> result = Lists.newArrayList();

    private static List<List<Integer>> solution(int[] nums, int target) {
        back(nums, 0,0, target, Lists.newArrayList());
        return result;
    }

    private static void back(int[] nums,int startIndex, int sum, int target, List<Integer> list) {
       if(sum==target){
           result.add(Lists.newArrayList(list));
            return;
       }
       for(int i=startIndex;i<nums.length;i++){
           if(sum+nums[i]<=target){
                list.add(nums[i]);
                back(nums,i,sum+nums[i],target,list);
                list.remove(list.size()-1);
           }

       }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> solution = solution(nums, 7);
        System.out.println(JSON.toJSONString(solution));
    }


}
