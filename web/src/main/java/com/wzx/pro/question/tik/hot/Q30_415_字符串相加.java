package com.wzx.pro.question.tik.hot;

public class Q30_415_字符串相加 {
    private static String solution(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int step = 0;
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int v1 = 0;
            int v2 = 0;
            if (index1 >= 0) {
                v1 = str1.charAt(index1)-'0';
            }
            if (index2 >= 0) {
                v2 = str2.charAt(index2)-'0';
            }
            int sum = v1 + v2 + step;
            step = sum / 10;
            int num = sum % 10;
            result.insert(0,num);

            index1--;
            index2--;
        }
        if (step > 0) {
            result.insert(0,step);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String solution = solution("11", "999");
        System.out.println(solution);
    }

}
