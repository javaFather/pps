package com.wzx.pro.question.compony;

import java.util.Arrays;

public class FieldInfo {

    private static int solution(int[] nums,int index){
        Arrays.sort(nums);
        int last =0;
        for(int i=nums.length-1;i>=0;i--){
            if(index==0){
                return last;
            }
            if(last!=nums[i]){
                last=nums[i];
                index--;
            }
        }
        return last;
    }


    private static int solution2(int[] nums,int index){
        int last =0;


        return last;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,6,4};
        int solution = solution(nums, 2);
        System.out.println(solution);
    }
}
