package com.wzx.pro.question.tik;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class Q15_31_下一个排列 {

    private static int[] solution(int[] nums){
        for(int i=nums.length-1;i>=0;i--){
            for(int j = nums.length-1;j>i;j--){
                if (nums[i]<nums[j]) {
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    Arrays.sort(nums,i+1,nums.length);
                    return nums;
                }

            }

        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3};
        int[] solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
    }
 }
