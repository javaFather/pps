package com.wzx.pro.question.home;

public class Q55 {
    private static  boolean solution(int[] nums){
        int k =0;
        for(int i =0;i<nums.length;i++){
            if(i>k){
                return false;
            }
            k=Math.max(k,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean solution = solution(nums);
        System.out.println(solution);
    }
}
