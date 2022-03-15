package com.wzx.pro.question.tik;

public class Q21_718_最长重复子数组 {

    private static int solution(int[] l1, int[] l2) {
        int max = 0;
        int[][] dp = new int[l1.length][l2.length];
        for (int i = 0; i < l1.length; i++) {
            for (int j = 0; j < l2.length; j++) {
                if (l1[i] == l2[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], 0) + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] l1 = {1, 2, 3, 2, 8};
        int[] l2 = {5, 6, 1, 4, 7};
        int solution = solution(l1, l2);
        System.out.println(solution);
    }
}
