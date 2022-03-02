package com.wzx.pro.question.compony;

public class Q202_快乐数 {

    private static boolean solution(int n){
        int slow = n;
        int fast = bitSquareSum(n);
        while (fast!=1 && slow !=fast){
            slow = bitSquareSum(slow);
            fast = bitSquareSum(bitSquareSum(fast));
        }
        return fast ==1;

    }


    private static  int bitSquareSum(int n){
        int sum =0;
        while (n>0) {
            int ys = n % 10;
            n = n / 10;
            sum = sum + ys * ys;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean solution = solution(2);
        System.out.println(solution);
    }
}
