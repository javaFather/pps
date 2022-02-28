package com.wzx.pro.question;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhenxing
 * @description
 * @date 2021/6/11 15:56
 */
public class TwoSum {

    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            //如果存在则返回
            Integer value = map.get(target - nums[i]);
            if(null !=value  && i!=value){
                return new int[]{value,i};
            }
            //不存在则存入
            map.put(nums[i],i);

        }
        return new int[0];

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            //剩余值
            int one = nums[i];
            int subValue =  target - one;
            if(map.containsKey(subValue)){
                return new int[]{i,map.get(subValue)};
            }
            map.put(one,i);
        }
        return new int[0];

    }

    public static int[] twoSumHash2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n0 = nums[i];
            int n1 = target - n0;
            if(map.containsKey(n1)) {
                return new int[] {i, map.get(n1)};
            }
            else {
                map.put(n0, i);
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
       int [] array = new int[]{1,2,3,4,5,6,7,8};
        int[] ints = twoSum1(array, 9);
        System.out.println(JSON.toJSONString(ints));
    }


}
