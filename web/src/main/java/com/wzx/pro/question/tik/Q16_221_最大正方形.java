package com.wzx.pro.question.tik;

public class Q16_221_最大正方形 {

    private static int solution(char[][] nums) {
        int length = nums.length;
        char[] num = nums[0];
        int[][] dp = new int[length][num.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j]=='1') {
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j] = Math.min(dp[i][j - 1],
                                Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max*max;
    }

    public static void main(String[] args) {
//        char[][] nums = {
//                {1, 0, 1, 0, 0},
//                {1, 0, 1, 1, 1},
//                {1, 1, 1, 1, 1},
//                {1, 0, 0, 1, 0}
//        };

        char[][] nums = {{'0','1'},{'1','0'}};

        int solution = solution(nums);
        System.out.println(solution);
    }
}
