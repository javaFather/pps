package com.wzx.pro.question;

public class Q11_c {
    public static  int solution(int[] nums){
        if(nums.length<2){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        int area = 0;
        while (right>left){
            int r = nums[right];
            int l = nums[left];
            int wide = right-left;
            if(r>=l){
                area = Math.max(area,l*wide);
                left++;
            }else {
                area = Math.max(area,r*wide);
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
