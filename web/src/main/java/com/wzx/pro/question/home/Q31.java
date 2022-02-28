package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class Q31 {
    private static int[] solution(int[] nums){
        for(int i= nums.length-1;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]<nums[j]){
                    int num = nums[i];
                    nums[i] = nums[j];
                    nums[j] = num;
                    Arrays.sort(nums,i+1,nums.length);
                    return nums;
                }

            }

        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        int[] solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
    }
}
