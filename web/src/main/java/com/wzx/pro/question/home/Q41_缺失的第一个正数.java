package com.wzx.pro.question.home;

public class Q41_缺失的第一个正数 {

    private static  int solution(int[] nums){
        for(int i=0;i<nums.length;i++){
            while (nums[i]>=1 && nums[i]<=nums.length && nums[i] != i+1) {
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
            }
        }

        for(int i =0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return nums.length+1;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
