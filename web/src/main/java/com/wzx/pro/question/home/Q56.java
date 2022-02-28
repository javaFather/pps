package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56 {

    private static List<List<Integer>> solution(int[][] nums) {
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int mergeLeft =nums[0][0];
        int mergeRight=nums[0][1];

        List<List<Integer>> result = Lists.newArrayList();
        for (int i = 1; i < nums.length; i++) {
            int[] item = nums[i];
            int left = item[0];
            int right = item[1];
            if(mergeLeft<=left && mergeRight>=left){
                if(mergeRight<=right){
                    mergeRight =right;
                }

            }else {
                List<Integer> integers = Lists.newArrayList(mergeLeft,mergeRight);
                result.add(integers);
                mergeLeft = left;
                mergeRight = right;
            }
        }
            result.add(Lists.newArrayList(mergeLeft,mergeRight));

        return result;
    }


    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {15, 18}, {2, 6}, {8, 10}};
//        int[][] nums = {{1, 4}, {4, 5}, {2, 6}, {8, 10}};
        List<List<Integer>> solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
    }
}
