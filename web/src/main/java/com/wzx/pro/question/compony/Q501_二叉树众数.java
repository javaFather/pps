package com.wzx.pro.question.compony;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class Q501_二叉树众数 {
    private  static int base=0;
    private  static int baseCount = 0;
    private  static int maxCount = 0;
   private static List<Integer> result = Lists.newArrayList();


    private static List<Integer> solution(TreeNode root) {
        if (root == null) {
            return Lists.newArrayList();
        }


        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            int val = pop.val;
            if (baseCount == 0) {
                base = val;
                baseCount++;
            } else {
                if (base == val) {
                    baseCount++;
                } else {
                    large(baseCount, maxCount, base);
                    base = val;
                    baseCount = 1;
                }
            }
            cur = pop.right;
        }
        large(baseCount, maxCount, base);


        return result;
    }

    private static void large(int baseCounts, int maxCounts, int base) {
        if (baseCounts > maxCounts) {
            maxCount = baseCounts;
            result.clear();
            result.add(base);
        } else if (baseCounts == maxCounts) {
            result.add(base);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root_left_1 = new TreeNode(2);
        TreeNode root_right_1 = new TreeNode(5);
        TreeNode root_left_1_1 = new TreeNode(2);
        TreeNode root_left_1_2 = new TreeNode(3);
        TreeNode root_right_2_2 = new TreeNode(6);
        root.left = root_left_1;
        root.right = root_right_1;
        root_left_1.left = root_left_1_1;
        root_left_1.right = root_left_1_2;
        root_right_1.right = root_right_2_2;
        List<Integer> solution = solution(root);
        System.out.println(JSON.toJSONString(solution));
    }
}
