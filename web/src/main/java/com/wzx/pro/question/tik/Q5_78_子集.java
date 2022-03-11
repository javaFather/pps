package com.wzx.pro.question.tik;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class Q5_78_子集 {

    private static List<List<Integer>> result = Lists.newArrayList();

    private static List<List<Integer>> solution(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            back(0,i, nums, Lists.newArrayList());
        }
        result.add(Lists.newArrayList());
        return result;
    }

    private static void back(int index,int count, int[] nums, List<Integer> item) {
        if (count == item.size()) {
            result.add(Lists.newArrayList(item));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (!item.contains(nums[i])) {
                item.add(nums[i]);
                back(i+1,count, nums, item);
                item.remove(item.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
    }
}
