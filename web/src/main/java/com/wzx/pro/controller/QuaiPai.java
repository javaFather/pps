package com.wzx.pro.controller;

import java.util.Arrays;

public class QuaiPai {
    public static void main(String[] args) {
        int[] array = {10,18,4,3,6,12,1,9,8};
        int[] ints = twoSum(array, 13);
        System.out.println(Arrays.toString(ints));
    }

    public  static  void kuaiPaiSort(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int base = arr[left];
        int i = left;
        int j = right;
        while (i!=j){
            while (arr[j]>=base && i<j){
                j--;
            }
            while(arr[i]<=base && i<j){
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
       arr[left]=  arr[i];
        arr[i]  = base;
        kuaiPaiSort(arr,left,i-1);
        kuaiPaiSort(arr,j+1,right);


    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i != j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }

            if (numbers[i] + numbers[j] < target) {
                i++;
                continue;
            }

            if (numbers[i] + numbers[j] > target) {
                j--;
                continue;
            }
        }

        return new int[]{i, j};
    }
}
