package com.wzx.pro.question.tik;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class Q9_22_括号生成 {
    private static List<String> result = Lists.newArrayList();

    private static List<String> solution(int n) {
        back(n, "", 0, 0);
        return result;
    }

    private static void back(int n, String str, int left, int right) {
        if (str.length() == n * 2) {
            result.add(str);
            return;
        }
        if (left < n) {
            back(n, str + "(", left + 1, right);
        }
        if (left > right) {
            back(n, str + ")", left, right + 1);
        }
    }

    public static void main(String[] args) {
        List<String> solution = solution(3);
        System.out.println(JSON.toJSONString(solution));
    }
}
