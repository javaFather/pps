package com.wzx.pro.question.tik.hot;

import com.alibaba.fastjson.JSON;

public class Q24_215_数组中的第K个最大元素 {
    private static int solution(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
//        int solution = solution(nums);
//        System.out.println(solution);
        int[] ints = quickSort(nums, 0, nums.length - 1);
        System.out.println(JSON.toJSONString(ints));
    }

    private static int[] quickSort(int[] nums, int start, int end) {
        int fistNum = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[right] > fistNum) {
                right--;
            }
            while (left < right && nums[left] < fistNum) {
                left++;
            }
            if (left < right && nums[left] == nums[right]) {
                left++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        if (left > start) {
            nums = quickSort(nums, start, left-1);
        }

        if (right < end) {
            nums = quickSort(nums, right+1, end);
        }

        return nums;
    }

}
