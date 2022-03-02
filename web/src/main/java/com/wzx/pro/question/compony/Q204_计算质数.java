package com.wzx.pro.question.compony;

public class Q204_计算质数 {

    private static int solution(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j * j < i; j++) {
                if (i % j == 0) {
                    count++;
                }

            }
        }
        return count;

    }

    public static void main(String[] args) {
        int solution = solution(10);
        System.out.println(solution);
    }
}
