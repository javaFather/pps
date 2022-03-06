package com.wzx.pro.question.compony;

import java.util.Arrays;

public class Q204_计算质数 {

    private static int solution(int n) {
        int count = 0;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for (int i = 2; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                if (i * i < n) {
                    for (int j = i * i; j < n; j = j + i) {
                        nums[j] = 0;
                    }
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
