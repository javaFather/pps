package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;

public class Q48_旋转图像 {

    private static int[][] solution(int[][] nums) {
        int len = nums.length;
        int position = len - 1;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < (len + 1) / 2; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[position - j][i];
                nums[position - j][i] = nums[position-i][position-j];
                nums[position-i][position-j]= nums[j][position-i];
                nums[j][position-i] = temp;
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] nums  ={{1,2,3,},{4,5,6},{7,8,9}};
        int[][] solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
    }


}
