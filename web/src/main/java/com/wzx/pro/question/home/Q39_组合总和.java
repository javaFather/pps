package com.wzx.pro.question.home;

import com.google.common.collect.Lists;

import java.util.List;

public class Q39_组合总和 {

    List<List<Integer>> result = Lists.newArrayList();

    public List<List<Integer>> solution(int[] nums, int target) {
        back(nums, 0,0, target, Lists.newArrayList());
        return result;
    }

    public  void back(int[] nums,int startIndex, int sum, int target, List<Integer> list) {
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
    }


}
