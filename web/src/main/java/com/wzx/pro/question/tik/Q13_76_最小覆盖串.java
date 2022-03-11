package com.wzx.pro.question.tik;

import com.google.common.collect.Maps;

import java.util.Map;

public class Q13_76_最小覆盖串 {
    private static String solution(String str, String include) {
        Map<Character, Integer> map = Maps.newHashMap();
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < include.length(); j++) {
            char key = include.charAt(j);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int length = str.length();
        int start = 0;
        int end = 0;
        while (start <= end) {
            char cur = str.charAt(end);
            if (!map.containsKey(cur)) {
                start++;
            }

        }

        return"";
}

    public static void main(String[] args) {
        String str = "ABCDEFGHIJ";
        String include = "CDE";
        solution(str, include);
    }
}
