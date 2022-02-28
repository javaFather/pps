package com.wzx.pro.question;

public class Q5_c {
    public static String solution(String str) {
        if (str.length() < 2) {
            return str;
        }
        int length = str.length();
        int start = 0;
        int end = 0;
        int max = 1;
        boolean[][] dp = new boolean[length][length];
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                char left = str.charAt(l);
                char right = str.charAt(r);
                if (left == right && (r - l<= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] =true;
                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        start = l;
                        end = r + 1;
                    }
                }
            }
        }

        return str.substring(start, end);
    }

    public static void main(String[] args) {
        String str = "一个上海单独的上海自来水来自海上";
        String solution = solution(str);
        System.out.println(solution);
    }
}
