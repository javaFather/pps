package com.wzx.pro.question.tik;

public class Q11_53_最大子数组和 {

    private static int solution(int[] nums) {
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(dp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
