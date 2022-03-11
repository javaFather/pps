package com.wzx.pro.question.tik;

public class Q12_5_最长回文子串 {

    private static String solution(String str) {
        int stepIndex = 0;
        int maxLength = 0;
        int length = str.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                char c1 = str.charAt(j);

                if (c != c1) {
                    dp[i][j] = false;
                } else {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }

                if (j - i + 1 > maxLength && dp[i][j]) {
                    maxLength = j - i + 1;
                    stepIndex = i;
                }


            }

        }

        return str.substring(stepIndex, stepIndex + maxLength);
    }

    public static void main(String[] args) {
        String str = "一个上海自来水来自海上的好人好";
        String solution = solution(str);
        System.out.println(solution);
    }


}

