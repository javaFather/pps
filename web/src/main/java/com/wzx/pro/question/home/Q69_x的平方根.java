package com.wzx.pro.question.home;

public class Q69_x的平方根 {

    private static int solution(int num) {
        return two(0, (num / 2) + 1, num);
    }

    private static int two(int left, int right, int num) {
        long mid = (right + left) / 2;
        if (mid * mid <= num && (mid + 1) * (mid + 1) > num) {
            return (int) mid;
        } else if (mid * mid > num) {
            return two(left, (int) mid - 1, num);
        } else {
            return two((int) mid + 1, right, num);
        }
    }

    public static void main(String[] args) {
        long solution = solution(2147395599);
        System.out.println(solution);
    }

}
