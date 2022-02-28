package com.wzx.pro.controller;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] array = {1,3,5,2,10,5,6,12,21};
        int startIndex = (array.length-1)/2;
        for(int i = startIndex;i>=0;i--){
            toMaxHeap(array,array.length,i);
            System.out.println(Arrays.toString(array));
        }
//        for(int i= array.length-1;i>0;i--){
//            int t = array[0];
//            array[0] = array[i] ;
//            array[i] = t;
//            toMaxHeap(array,i,0);
//        }

    }

    public static void toMaxHeap(int[] array,int size,int index){
        int left = index*2+1;
        int right = index*2+2;
        int max = index;
        if(left< size && array[left]>array[max]){
            max = left;
        }
        if(right< size && array[right]>array[max]){
            max = right;
        }
        if(max!=index){
            int t = array[max];
            array[max] = array[index];
            array[index] = t;
            toMaxHeap(array,size,max);


        }

    }


}
