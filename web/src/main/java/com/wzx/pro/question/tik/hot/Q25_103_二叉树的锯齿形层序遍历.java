package com.wzx.pro.question.tik.hot;

import com.alibaba.fastjson.JSON;
import com.wzx.pro.question.tik.TreeNode;

import java.util.*;

public class Q25_103_二叉树的锯齿形层序遍历 {
    private static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean flag = true;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                stack2 = revert(flag, stack1, stack2, result);
                flag = !flag;
            }
            if (!stack2.isEmpty()) {
                stack1 = revert(flag, stack2, stack1, result);
                flag = !flag;
            }
        }
        return result;
    }

    private static Stack<TreeNode> revert(boolean flag, Stack<TreeNode> stack, Stack<TreeNode> stack2, List<List<Integer>> result) {
        List<Integer> item = new LinkedList<>();
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            item.add(left.val);
            if (flag) {
                if (left.left != null) {
                    stack2.push(left.left);
                }
                if (left.right != null) {
                    stack2.push(left.right);
                }
            } else {
                if (left.right != null) {
                    stack2.push(left.right);
                }
                if (left.left != null) {
                    stack2.push(left.left);
                }

            }

        }
        result.add(new ArrayList<>(item));

        return stack2;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left_1 = new TreeNode(9);
        TreeNode right_1 = new TreeNode(20);
        TreeNode left_2 = new TreeNode(15);
        TreeNode right_2 = new TreeNode(7);
        root.left = left_1;
        root.right = right_1;
        right_1.left = left_2;
        right_1.right = right_2;
        List<List<Integer>> solution = solution(root);
        System.out.println(JSON.toJSONString(solution));
    }

}
