package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;

public class Q48_旋转图像 {

    private static int[][] solution(int[][] nums) {
        return new int[][]{};
    }

    public static void main(String[] args) {
        int[][] nums  ={{1,2,3,},{4,5,6},{7,8,9}};
        int[][] solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
        StringBuilder str = new StringBuilder();
        str.append('A');
        str.append('B');
        str.append('C');
        str.deleteCharAt(str.length()-1);
        System.out.println(str.toString());
    }


}
