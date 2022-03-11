package com.wzx.pro.question.tik;

public class Q7_209_长度最小的子数组 {

    private static int minLength = Integer.MAX_VALUE;

    private static int solution(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            if (sum >= target) {
                minLength = Math.min(1, minLength);
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLength = Math.min(j - i + 1, minLength);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }

    //滑动窗口


    private static int slowWindow(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                min = Math.min(right - left + 1, min);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int solution = solution(nums, 7);
        int i = slowWindow(nums, 7);
        System.out.println(i);
        System.out.println(solution);
    }
}
