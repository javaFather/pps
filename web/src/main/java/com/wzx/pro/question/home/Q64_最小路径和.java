package com.wzx.pro.question.home;

public class Q64_最小路径和 {
    private static int solution(int[][] nums){

        int rows = nums.length;
        int cols = nums[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = nums[0][0];
        for(int i=1;i<nums.length;i++){
            dp[i][0]=dp[i-1][0]+nums[i][0];
        }
        for(int j=1;j<cols;j++){
            dp[0][j]=dp[0][j-1]+nums[0][j];
        }
        for(int i = 1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+nums[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
