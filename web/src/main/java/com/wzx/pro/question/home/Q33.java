package com.wzx.pro.question.home;

public class Q33 {
    private static int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[left]<=nums[mid]){
                //左连续递增
                if(nums[left]<=target && nums[mid]>target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }

            }else {
                //右连续递增
                if(nums[mid]<=target && nums[right]>target){
                    left = mid+1;
                }else {
                    right =mid-1;
                }
            }

        }


        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,9,1,2,3,4,5,6,7};
        int solution = solution(nums, 6);
        System.out.println(solution);
    }
}
