package com.wzx.pro.interview;

public class pdd_1 {
    private static int handle1(int[] price) {
        //1.0
        int[][] dp = new int[price.length][2];
        dp[0][0] = 0;
        dp[0][1] = -price[0];
        for (int i = 1; i < price.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + price[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -price[i]);
        }
        return dp[price.length - 1][0];
    }

    private static int handel3(int[] prices) {
        int buy1 = -prices[0], sel1 = 0;
        int buy2 = -prices[0], sel2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(-prices[i], buy1);
            sel1 = Math.max(buy1 + prices[i], sel1);
            buy2 = Math.max(sel1 - prices[i], buy2);
            sel2 = Math.max(buy2 + prices[i], sel2);
        }
        return sel2;
    }
}
