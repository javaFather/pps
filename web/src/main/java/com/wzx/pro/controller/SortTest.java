package com.wzx.pro.controller;

import com.alibaba.fastjson.JSON;

public class SortTest {
    /**
     * 插入排序
     *
     * @param data
     */
    public static void insertSort(int[] data) {
        int temp;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];//待插入数据
            int j;
            for (j = i - 1; j >= 0; j--) {
                //判断是否大于temp，大于则后移一位
                if (data[j] > temp) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * @param data
     */
    public static void bubbleSort(int[] data) {

        int j, k;

        int flag = data.length;//flag来记录最后交换的位置，也就是排序的尾边界

        while (flag > 0) {//排序未结束标志

            k = flag; //k 来记录遍历的尾边界

            flag = 0;

            for (j = 1; j < k; j++) {

                if (data[j - 1] > data[j]) {//前面的数字大于后面的数字就交换

                    //交换a[j-1]和a[j]

                    int temp;

                    temp = data[j - 1];

                    data[j - 1] = data[j];

                    data[j] = temp;

                    //表示交换过数据

                    flag = j;//记录最新的尾边界

                }

            }

        }

    }


    public static void main(String[] args) {
        int[] list = {12, 1, 32, 13,15,18,21};
        bubbleSort(list);
        System.out.println(JSON.toJSON(list));
    }
}