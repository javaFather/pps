package com.wzx.pro.question.home;

public class Q53_最大子数组和 {

    private static int solution(int[] nums) {
        int maxPath = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            maxPath = Math.max(maxPath+nums[i],nums[i]);
            max = Math.max(max,maxPath);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int solution = solution(nums);
        int i = mySolution(nums);
        System.out.println(i);
        System.out.println(solution);
    }


    private static int mySolution(int[] nums) {
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > max) {
                    max = sum;
                }
            }

        }
        return max;
    }


}
