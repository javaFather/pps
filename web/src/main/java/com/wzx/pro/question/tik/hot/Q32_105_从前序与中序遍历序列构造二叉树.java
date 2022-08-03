package com.wzx.pro.question.tik.hot;

import com.wzx.pro.question.tik.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q32_105_从前序与中序遍历序列构造二叉树 {
    private static TreeNode solution(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        return tree(nums1, 0, nums1.length - 1, 0, nums2.length - 1, map);
    }

    private static TreeNode tree(int[] nums1, int left1, int right1, int left2, int right2, Map<Integer, Integer> map) {
        if (left1 > right1 || left2 > right2) {
            return null;
        }
        TreeNode root = new TreeNode(nums1[left1]);
        //左边起点0-index;
        Integer index = map.get(nums1[left1]);
        root.left = tree(nums1, left1 + 1, left1+ index - left2,left2,index-1,map );
        root.right = tree(nums1, left1+ index - left2 + 1, right1,index+1,right2,map );

        return root;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,9,20,15,7};
        int[] nums2 = {9,3,15,20,7};
        TreeNode solution = solution(nums1, nums2);
        System.out.println(solution);
    }
}
