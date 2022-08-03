package com.wzx.pro.question.tik.hot;

public class Q26_121_买卖股票的最佳时机 {

    private static int solution(int[] nums) {
        int lefMin = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lefMin) {
                lefMin = Math.min(lefMin, nums[i]);
            } else {
                max = Math.max(max, nums[i] - lefMin);
            }
        }

        return max;

    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
     * @param nums
     * @return
     */
    private static int solution2(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(nums[i] - nums[0], dp[0][i - 1]);

        }
        for (int i = 1; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = nums[j] - nums[i];
                dp[i][j] = Math.max(num,Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[nums.length - 2][nums.length - 1];

    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int solution = solution2(nums);
        System.out.println(solution);
    }
}
