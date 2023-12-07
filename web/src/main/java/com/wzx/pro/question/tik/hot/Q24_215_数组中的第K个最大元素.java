package com.wzx.pro.question.tik.hot;

import com.alibaba.fastjson.JSON;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q24_215_数组中的第K个最大元素 {


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
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = quickSortMain(arr, startIndex, endIndex);
        // 用分界值下标区分出左右区间，进行递归调用
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }


    private static int quickSortMain(int[] nums,int startLeft,int startRight){
        int firstNum = nums[startLeft];
        int left =startLeft;
        int right = startRight;
        while(left<right){
            while(left<right && nums[left]<=firstNum){
                left++;
            }
            while(left<right && nums[right]>firstNum){
                right--;
            }
            if(left<right){
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }

        }
        nums[startLeft] =nums[right];
        nums[right]=firstNum;
        return right;
    }



    private static void maxSubArray(int[] nums) {
            int len = nums.length;


    }
}
