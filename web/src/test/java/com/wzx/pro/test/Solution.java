package com.wzx.pro.test;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        //tails数组是以当前长度连续子序列的最小末尾元素
        //如tail[0]是求长度为1的连续子序列时的最小末尾元素
        //例：在 1 6 4中 tail[0]=1 tail[1]=4 没有tail[2] 因为无法到达长度为3的连续子序列
        int tails[] = new int[nums.length];
        //注意：tails一定是递增的 因为看题解那个动画 我们最开始的那个元素一定找的是该数组里最小的 不然如果不是最小 由于我们需要连续 后面的数一定会更大（这样不好的原因是 数越小 我们找到一个比该数大的数的几率肯定会更大）
        int res = 0;
        for (int num : nums) {
            //每个元素开始遍历 看能否插入到之前的tails数组的位置 如果能 是插到哪里
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            //如果没有到达j==res这个条件 就说明tail数组里只有部分比这个num要小 那么就把num插入到tail数组合适的位置即可 但是由于这样的子序列长度肯定是没有res长的 因此res不需要更新
            tails[i] = num;
            //j==res 说明目前tail数组的元素都比当前的num要小 因此最长子序列的长度可以增加了
            if (j == res) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18,1};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}