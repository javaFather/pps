package com.wzx.pro.question.retry;

import com.google.common.collect.Maps;

import java.util.Map;

public class Q5_3_无重复字符的最长子串长度 {

    private static int solution(String str) {

        Map<Character, Integer> map = Maps.newHashMap();
        int max = 0;
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            Integer oldIndex = map.get(key);
            if (oldIndex != null && left <= oldIndex) {
                left = oldIndex + 1;
            }
            max = Math.max(max, i - left + 1);
            map.put(key,i);
        }
        return max;
    }


    public static void main(String[] args) {
        String s = "abcdasdfght";
        int solution = solution(s);
        System.out.println(solution);
    }

}
