package com.wzx.pro.question.home;

import java.util.Arrays;

public class Q698_划分为k个相等的子集 {

    private static boolean solution(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int sum = Arrays.stream(nums).sum();
        //不能分成K份
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / k;
        //最大值超过了 平均值，单独作为一个集合都不能等于目标值
        if (nums[nums.length - 1] > target) {
            return false;
        }

        boolean[] used = new boolean[nums.length];

        return dfs(nums, nums.length - 1, target, 0, k, used);
    }

    private static boolean dfs(int[] nums, int begin, int target, int curSum, int k, boolean[] used) {
        if (k == 1) {
            return true;
        }
        if (curSum == target) {
            return dfs(nums, nums.length - 1, target, 0, k - 1, used);
        }

        for (int i = begin; i >= 0; i--) {
            if (used[i]) {
                continue;
            }

            if (curSum + nums[i] > target) {
                continue;
            }
            used[i] = true;
            if (dfs(nums, i - 1, target, curSum + nums[i], k, used)) {
                return true;
            }
            used[i] = false;//回溯
            while (i > 0 && nums[i - 1] == nums[i])//剪枝3
                i--;
        }
        return false;


    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 1, 11};
        System.out.println(solution(nums, 3));
    }


}
