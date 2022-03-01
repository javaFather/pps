package com.wzx.pro.question;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class _94 {

    //中序遍历二叉树
    public static List solution(TreeNode root) {
        List result = Lists.newArrayList();
        if (root == null) {
            return result;
        }
        List left = solution(root.left);
        result.addAll(left);
        result.add(root.val);
        List right = solution(root.right);
        result.addAll(right);
        return result;

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List result = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            cur = pop.right;
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
        List solution = inorderTraversal(root);
        List solution1 = solution(root);
        System.out.println(JSON.toJSONString(solution));
        System.out.println(JSON.toJSONString(solution1));

    }
}
