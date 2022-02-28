package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;

public class Q34 {

    private static  int[] solution(int[] nums,int target){
        int left = findLeft(nums,target);
        int right = findRight(nums, target);
        return new int[]{left,right};
    }


    private static  int findLeft(int[] nums,int target){
        int left = 0 ;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                if(mid ==0 || nums[mid-1]!=target){
                    return mid;
                }else {
                    right = mid-1;
                }
            }else if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;

    }
    private static  int findRight(int[] nums,int target){
        int left = 0 ;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                if(mid ==nums.length-1 || nums[mid+1]!=target){
                    return mid;
                }else {
                    right = mid-1;
                }
            }else if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{5,7,7,8,8,10};
        int[] solution = solution(nums, 8);
        System.out.println(JSON.toJSONString(solution));
    }
}
