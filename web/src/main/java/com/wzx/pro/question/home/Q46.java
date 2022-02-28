package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class Q46 {

   private static List<List<Integer>> result=Lists.newArrayList() ;
    private static  List<List<Integer>> solution(int[] nums){
        back(nums,Lists.newArrayList(),Lists.newArrayList(),0);
        return result;
    }

    private static  void back(int[] nums,List<Integer> index, List<Integer> list ,int depth){
        if(depth==nums.length){
            result.add(Lists.newArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!index.contains(i)){
                list.add(nums[i]);
                index.add(i);
                back(nums,index,list,depth+1);
                list.remove(list.size()-1);
                index.remove(index.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> solution = solution(nums);
        System.out.println(JSON.toJSONString(solution));
    }
}
