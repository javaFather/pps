package com.wzx.pro.question;

import com.alibaba.fastjson.JSON;

public class Q33_c {
    //todo 待完成 sss
    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 7, 8, 8, 8, 8, 10};
        int[] ints = searchRange(nums, 8);
        System.out.println(JSON.toJSONString(ints));
    }

    public static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {


        }
        return 0;

    }

}
