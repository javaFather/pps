package com.wzx.pro.question.retry;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class Q9_15_三数之和 {
    private static List<List<Integer>> result = Lists.newArrayList();

    private static List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (item > 0) {
                return result;
            } else if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            } else {
                twosum(-item, nums, i + 1, nums.length - 1);
            }
        }

        return result;
    }


    private static void twosum(int num, int[] nums, int left, int right) {
        while (left < right) {
            int lnum = nums[left];
            int rnum = nums[right];
            int sum = lnum + rnum;
            if (sum == num) {
                List<Integer> item = Lists.newArrayList(-num, lnum, rnum);
                result.add(item);
                do{
                    left++;
                }while (left<right && nums[left]==nums[left-1]);
            } else if (sum > num) {
                right--;
            } else {
                left++;
            }


        }


    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 4, 3};
        List<List<Integer>> solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
    }
}
