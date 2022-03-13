package com.wzx.pro.question.tik;

import com.google.common.collect.Maps;

import java.util.Map;

public class Q13_76_最小覆盖串 {
    private static String solution(String str, String include) {
        Map<Character, Integer> map = Maps.newHashMap();
        Map<Character, Integer> strMap = Maps.newHashMap();

        int count = 0;
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int j = 0; j < include.length(); j++) {
            char key = include.charAt(j);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int length = str.length();
        int start = 0;
        int end = 0;
        while (end < length) {
            char right = str.charAt(end);
            if (map.containsKey(right)) {
                strMap.put(right, strMap.getOrDefault(right, 0) + 1);
                Integer integer = strMap.get(right);
                Integer aim = map.get(right);
                if (integer <= aim) {
                    count++;
                }
            }

            while (start <= end && count == include.length()) {
                char left = str.charAt(start);
                if (!map.containsKey(left)) {
                    start++;
                } else {
                    Integer integer = strMap.get(left);
                    Integer integer1 = map.get(left);
                    if (integer.equals(integer1)) {
                        if(min>end-start+1){
                            min = end-start+1;
                            index = start;
                        }
                        count--;
                    }
                    strMap.put(left, strMap.get(left) - 1);
                    start++;
                }

            }
            end++;

        }

        return min ==Integer.MAX_VALUE?"":str.substring(index, index + min);
    }

    public static void main(String[] args) {
        String str = "cwaefgcf";
        String include = "cae";
        String solution = solution(str, include);
        System.out.println(solution);
    }
}
