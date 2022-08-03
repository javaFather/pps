package com.wzx.pro.question.tik.hot;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q24_215_数组中的第K个最大元素 {
    private static int solution(int[] nums,int k) {
        int[] sorNums = quickSort(nums, 0, nums.length - 1);
        return sorNums[sorNums.length-k];
    }

    private static  int solution2(int[] nums,int k){
        Queue<Integer> queue = new PriorityQueue<>();
        for (Integer item :nums){
                queue.offer(item);
                if(queue.size()>k){
                    queue.poll();
                }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int solution = solution(nums,4);
        System.out.println(solution);
    }

    private static int[] quickSort(int[] nums,int start,int end) {
        int startNum = nums[start];
        int left =start;
        int right =end;
        while (left < right) {
          while (left < right && nums[right]>startNum){
              right--;
          }
          while (left < right && nums[left]<startNum){
              left++;
          }
          if (left<right && nums[left]==nums[right]){
              left++;
          }else{
              int temp = nums[left];
              nums[left]=nums[right];
              nums[right]= temp;
            }
        }

        if(left>start){
           nums= quickSort(nums,start,left-1);
        }

        if(end>right){
            nums= quickSort(nums,right+1,end);
        }

        return nums;
    }

}
