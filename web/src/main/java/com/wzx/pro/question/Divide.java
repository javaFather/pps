package com.wzx.pro.question;

public class Divide {

    public static int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) /2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int search = search(a, 3);
        System.out.println(search);
    }
}
