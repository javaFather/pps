package com.wzx.pro.question.home;

import java.util.Arrays;

/**
 * 输入：[1, 5, 11, 5]， 输出：[1, 5, 5]和[11]
 */
public class Q416_划分数组为两个相等的子集 {

    private static boolean solution(int[] nums){
        int sum =0;
        for(int i = 0;i<nums.length;i++){
            sum = sum +nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        for(int i =0;i<nums.length;i++){
            for (int j=target;j>=nums[i];j--){
                dp[j]=dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,5,11};
//        boolean solution = solution(nums);
//        System.out.println(solution);

        int b = canPartition(nums);
        System.out.println(b);
    }


    //划分和相等的子集

    public static int canPartition(int[] nums) {
        // sum用来记录总和
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 !=0) {
            return -1;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        if(nums[nums.length-1]>target){
            return -1;
        }
        int row = nums.length+1;
        int col = target + 1;

        // dp[i]表示是否有这样一种可行方案使得元素和为i
        int[][] dp = new int[row][col];
        //容积为target的背包，nums.length 个商品，一个target背包

        for(int i = 1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = dp[i-1][j];
                if(j-nums[i-1]>=0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }

            }

        }

        return dp[row-1][col-1];
    }


}
