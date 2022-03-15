package com.wzx.pro.question.tik;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class Q19_322_零钱兑换NO {




    /**动态规划
     *
     * @param nums
     * @param target
     * @return
     */
    private static int solution(int[] nums, int target) {
      int[] dp = new int[target+1];
      Arrays.fill(dp,Integer.MAX_VALUE);
      dp[0]=0;
      for(int i=1;i<=target;i++){
          for (int coin:nums){
              if(i-coin>=0){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
              }
          }
      }


        return dp[target]==Integer.MAX_VALUE?-1:dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int target = 3;
        int solution = solution(nums, target);
//        int coinChange = coinChange(nums, target);
        System.out.println(JSON.toJSONString(solution));
//        System.out.println(JSON.toJSONString(coinChange));
    }




    /**
     * 最小使用数量
     * @param nums
     * @param target
     * @return
     */
    private static int min;

    private static int coinChange(int[] nums, int target) {
        min = Integer.MAX_VALUE;
        //总金额 amount 当前使用数量 cur
        back1(0, target, nums, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static void back1(int amount, int target, int[] nums, int cur) {
        if (amount == target) {
            min = Math.min(min, cur);
            return;
        }
        for (int num : nums) {
            if (amount + num <= target) {
                back1(amount + num, target, nums, cur + 1);
            }
        }
    }

}
