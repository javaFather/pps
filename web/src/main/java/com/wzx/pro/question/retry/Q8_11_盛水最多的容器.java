package com.wzx.pro.question.retry;

public class Q8_11_盛水最多的容器 {

    private static int solution(int[] nums){
        int length = nums.length;
        int left = 0;
        int right =length-1;
        int are = 0;
        while (left<right){
            int lnum = nums[left];
            int rnum = nums[right];
            if(lnum<=rnum){
                are = Math.max(are,lnum*(right-left+1));
               left++;
            }else {
               right--;
                are = Math.max(are,rnum*(right-left+1));
            }
        }

        return are;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
