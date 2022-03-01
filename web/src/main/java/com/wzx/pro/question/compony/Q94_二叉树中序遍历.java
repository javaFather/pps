package com.wzx.pro.question.compony;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class Q94_二叉树中序遍历 {
    //中序
    private static List<Integer> solution(TreeNode root) {
        if (null == root) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        List<Integer> result = Lists.newArrayList();
        while (pre != null || !stack.isEmpty()) {
            while (pre != null) {
                stack.push(pre);
                pre = pre.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            pre = pop.right;
        }
        return result;
    }

    //先序
    private static List<Integer> solutionFirst(TreeNode root) {
        if (null == root) {
            return Lists.newArrayList();
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = Lists.newArrayList();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                result.add(cur.val);
                cur = cur.left;
            }
            TreeNode poll = stack.pop();
            cur = poll.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_left_1 = new TreeNode(2);
        TreeNode root_right_1 = new TreeNode(3);
        TreeNode root_left_1_1 = new TreeNode(4);
        TreeNode root_left_1_2 = new TreeNode(5);
        TreeNode root_right_2_2 = new TreeNode(6);
        root.left = root_left_1;
        root.right = root_right_1;
        root_left_1.left = root_left_1_1;
        root_left_1.right = root_left_1_2;
        root_right_1.right = root_right_2_2;
        List<Integer> solution = solution(root);
        List<Integer> solutionFirst = solutionFirst(root);
        System.out.println(JSON.toJSONString(solution));
        System.out.println(JSON.toJSONString(solutionFirst));
    }
}
