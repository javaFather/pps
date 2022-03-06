package com.wzx.pro.question.home;

public class Q_矩形最小路径和 {

    private static int solution(int[][] nums) {
        int col = nums.length;
        int row = nums[0].length;
        int[][] dp = new int[col][row];

        dp[0][0] =nums[0][0];

        for (int i = 1; i < col; i++) {
            dp[i][0] = dp[i-1][0]+nums[i][0];
        }
        for (int j = 1; j < row; j++) {
            dp[0][j] = dp[0][j-1]+nums[0][j];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) +nums[i][j];
            }

        }

        return dp[col-1][row-1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
