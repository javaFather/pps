package com.wzx.pro.question.home;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class Q15_三数之和 {

    private static List<List<Integer>> result = Lists.newArrayList();

    private static List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            } else if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                int num = nums[i];
                twoSum(nums, i + 1, nums.length-1, -num);
            }

        }
        return result;
    }

    private static void twoSum(int[] nums, int left, int right, int target) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> item = Lists.newArrayList(-target, nums[left], nums[right]);
                result.add(item);
                do {
                    left++;
                } while (left < nums.length && nums[left - 1] == nums[left]);
                left++;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

    }

    public static void main(String[] args) {
//     int[] nums = new int[]{-1,0,1,2,-1,-4};
     int[] nums = new int[]{0,0,0,0,0,0,0};
        List<List<Integer>> solution = solution(nums);
        System.out.println(solution);
    }
}
