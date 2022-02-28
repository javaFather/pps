package com.wzx.pro.question;

import com.alibaba.fastjson.JSON;

public class FirstAndLastPosition {
        public static int[] searchRange(int[] nums, int target) {
            int min = 0;
            int max = nums.length - 1;
            //定义好第一个和最后一个的下标
            int first = -1, last = -1;
            while (min <= max) {
                int middle = min + (max - min) / 2;
                if (nums[middle] > target) {
                    //如果中位数大于target，则说明target在左区间
                    max = --middle;
                } else if (nums[middle] < target) {
                    //如果中位数小于target，则说明target在右区间
                    min = ++middle;
                } else {
                    if (middle == 0 || (nums[middle - 1] != target)) {
                        first = middle;
                        break;
                    } else {
                        max = --middle;
                    }
                }
            }
            //如果first==-1 说明上面的查找没找到该元素  则直接返回{-1, -1}
            if (first == -1) {
                return new int[]{first, last};
            }
            //从第一个等于target的元素往后遍历 直到找到最后一个等于target的元素
            for (int i = first; i < nums.length; i++) {
                if (nums[i] != target) {
                    break;
                }
                if (nums[i] == target) {
                    last = i;
                }
            }
            return new int[]{first, last};
        }

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{1, 2, 3, 4,4,4,5,6,6,6}, 4);
        System.out.println(JSON.toJSONString(ints));
    }
}
