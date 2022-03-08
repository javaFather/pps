package com.wzx.pro.question.retry;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class Q10_17_电话号码的字母组合 {

    private static Map<Character, String> map = Maps.newHashMap();

    private static List<String> result = Lists.newArrayList();


    private static List<String> solution(String str) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        //
        back(str, 0, "");
        return result;
    }

    private static void back(String str, int index, String obj) {
        if (obj.length() == str.length()) {
            result.add(obj);
            return;
        }
        char key = str.charAt(index);
        String aim = map.get(key);
        for (int j = 0; j < aim.length(); j++) {
            char val = aim.charAt(j);
            if (obj.length() < str.length()) {
                back(str, index + 1, obj + val);
            }
        }
    }

    public static void main(String[] args) {
        List<String> solution = solution("293");
        System.out.println(JSON.toJSONString(solution));
    }
}
