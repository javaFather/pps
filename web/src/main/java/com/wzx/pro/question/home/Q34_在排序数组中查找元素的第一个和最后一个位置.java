package com.wzx.pro.question.home;

public class Q34_在排序数组中查找元素的第一个和最后一个位置 {

    class Solution {
        public boolean canJump(int[] nums) {
            int k =0;
            for(int i =0;i<nums.length;i++){
                if(i>k){
                    return false;
                }
                k=Math.max(k,i+nums[i]);
            }
            return true;
        }
    }
}
