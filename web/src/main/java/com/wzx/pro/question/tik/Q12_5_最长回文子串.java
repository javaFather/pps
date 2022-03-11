package com.wzx.pro.question.tik;

public class Q12_5_最长回文子串 {

    private static String solution(String str) {
        int max = 1;
        int index = 0;

        int length = str.length();
        if (length < 2) {
            return str;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (str.charAt(i) != str.charAt(j)) {
                    dp[j][i] = false;
                } else {
                    if (i - j < 2) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (i - j + 1 > max && dp[j][i]) {
                    max = i - j + 1;
                    index = j;
                }

            }

        }

        return str.substring(index, index + max);
    }

    public static void main(String[] args) {
        String str = "一个上海自来水来自海上的好人好";
        String solution = solution(str);
        System.out.println(solution);
    }


}

