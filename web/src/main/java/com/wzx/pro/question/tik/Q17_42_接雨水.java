package com.wzx.pro.question.tik;

import java.util.Arrays;

public class Q17_42_接雨水 {
    private static int solution(int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            int lHeight = nums[left];
            int rHeight = nums[right];
            //计算面积
            if (rHeight >= lHeight) {
                sum = area(left, right, nums, sum);
                left = right;
            }
            right++;
        }
        if (right == nums.length && right != left) {
            int[] rightNumbers = Arrays.copyOfRange(nums, left, right);
            int l = rightNumbers.length - 2;
            int r = rightNumbers.length - 1;
            while (l >= 0) {
                int lCount = rightNumbers[l];
                int rCount = rightNumbers[r];
                if (lCount >= rCount) {
                    int with = r - l - 1;
                    //最大面积
                    int area = rCount * with;
                    //减去中间面积
                    int reduce = 0;
                    for (int i = r - 1; i > l; i--) {
                        reduce = rightNumbers[i] + reduce;
                    }
                    sum = sum + (area - reduce);
                    r = l;
                }
                l--;
            }
        }

        return sum;
    }

    private static int area(int left, int right, int[] nums, int sum) {
        int lHeight = nums[left];
        int rHeight = nums[right];
        //计算面积
        if (rHeight >= lHeight) {
            int with = right - left - 1;
            //最大面积
            int area = lHeight * with;
            //减去中间面积
            int reduce = 0;
            for (int i = left + 1; i < right; i++) {
                reduce = nums[i] + reduce;
            }
            sum = sum + (area - reduce);
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 2, 3};
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int solution = solution(nums);
        int solution2 = solution2(nums);
        System.out.println(solution);
        System.out.println(solution2);
    }

    //双指针
    private static int solution2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int left_max = 0;
        int right_max = 0;
        int area = 0;
        while (left < right) {
            if (nums[left] < nums[right]) {
                if (nums[left] > left_max) {
                    left_max = nums[left];
                } else {
                    area += left_max - nums[left];
                }
                left++;
            } else {
                if (nums[right] > right_max) {
                    right_max = nums[right];
                } else {
                    area += right_max - nums[right];
                }
                right--;
            }

        }

        return area;
    }
}
