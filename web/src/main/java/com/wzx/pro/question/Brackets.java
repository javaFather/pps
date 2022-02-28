package com.wzx.pro.question;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class Brackets {

    public static List solution(int nums){
        String str = "(";
        return null;
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = Lists.newArrayList();
        if (n <= 0) return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private static  void dfs(int n, String path, List<String> res, int open, int close) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        if (open < n) {
            dfs(n, path + "(", res, open + 1, close);
        }
        if (close < open) {
            dfs(n, path + ")", res, open, close + 1);
        }
    }


    public static void main(String[] args) {
        List solution = generateParenthesis(3);
        System.out.println(JSON.toJSONString(solution));
    }
}
