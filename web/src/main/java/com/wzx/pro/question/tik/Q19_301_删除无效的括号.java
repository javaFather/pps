package com.wzx.pro.question.tik;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Q19_301_删除无效的括号 {

    private static List<String> solution(String str) {
        char left = '(';
        char right = ')';
        int left_count = 0;
        int right_count = 0;
        int ignore = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] == left) {
                left_count++;
            } else if (chars[i] == right) {
                right_count++;
                if (right_count > left_count) {
                    right_count--;
                    ignore++;
                }
            }
        }
        System.out.println(ignore);
        return null;
    }

    public static void main(String[] args) {
        String str = ")(";
        List<String> solution = solution(str);
        System.out.println(JSON.toJSONString(solution));
    }
}
