package com.wzx.pro.question.home;

public class Q_01背包问题 {

    private static int solution() {
        //五个商品
        int n = 5;
        //容量是10 的背包
        int c = 10;
        //五个商品分别对应的重量和 价值
        int[] w = {0, 2, 2, 6, 5, 4};
        int[] v = {0, 6, 3, 5, 4, 6};

        int[][] dp = new int[6][11];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = dp[i-1][j];
                //当前i商品可以被放下
                if(j-w[i]>=0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }

        }


        return dp[n][c];
    }

    public static void main(String[] args) {
        int solution = solution();
        System.out.println(solution);
    }
}
