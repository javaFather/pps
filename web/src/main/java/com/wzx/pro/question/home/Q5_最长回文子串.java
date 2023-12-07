package com.wzx.pro.question.home;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class Q5_最长回文子串 {
    public static String solution(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }


    public static String mySolution(String str) {
        int length = str.length();
        if (length < 2) {
            return str;
        }
        int maxlen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] charArray = str.toCharArray();

        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                //右边界
                int j = L + i - 1;
                if (j >= length) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j + i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];

                    }
                }

                if (dp[i][j] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    begin = i;
                }

            }

        }


        return str.substring(begin, begin + maxlen);


    }


    public static void main(String[] args) {
        String str = "cbbd";
//        String solution = solution(str);
//        System.out.printf(solution);
//        String max = max(str);
//        System.out.println(max);
        String s = countSubstrings(str);
        System.out.println(s);

    }

    public static String max(String str) {
        String result = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String temp = str.substring(i, j + 1);
                String temp2 = StringRevers(temp);
                if (temp.equals(temp2) && (StringUtils.isEmpty(result) || result.length() < temp.length())) {
                    result = temp;
                }

            }

        }

        return result;
    }

    public static String StringRevers(String str) {
        Stack stack = new Stack();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (stack.size() > 0) {
            result = result.append(stack.pop());
        }
        return result.toString();
    }

        public static String countSubstrings(String s) {
            // 动态规划法
            boolean[][] dp = new boolean[s.length()][s.length()];
            int max = 0;
            int index =0;
            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if(j-i+1>max){
                            max = j-i+1;
                            index =i;
                        }
                    }
                }
            }

            return s.substring(index,index+max);
    }


}
