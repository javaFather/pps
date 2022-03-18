package com.wzx.pro.question.home;

public class Q69_x的平方根 {

    private static int solution(int num) {
        int result =0;
        for (long i = 0; i <=(num / 2) + 1; i++) {
            long item = i+1;
            if (i * i <= num && item * item > num) {
                result = Integer.parseInt(String.valueOf(i));
            }
        }
        return result;
    }

    private static int two(int left ,int right){

        return 0;
    }

    public static void main(String[] args) {
        long solution = solution(2147395599);
        System.out.println(solution);
    }

}
