package com.wzx.pro.question.home;

/**
 * 有 N 阶楼梯，每次可上一阶或两阶，求有多少种上楼梯的方法
 */
public class Q_跳台阶 {
    private static int solution(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <n; i++) {
            dp[i] = dp[i - 1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int solution = solution(20);
        int solution2 = solution2(20);
        System.out.println(solution);
        System.out.println(solution2);
    }

    private static int solution2(int n) {
        if (n < 3) {
            return n;
        } else {
            int i = 1;
            int j = 2;
            int res = 0;
            for (int k = 0; k < n - 2; k++) {
                res = i + j;
                i = j;
                j = res;

            }
            return res;
        }
    }

}
