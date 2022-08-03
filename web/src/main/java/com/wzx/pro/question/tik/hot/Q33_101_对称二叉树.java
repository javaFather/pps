package com.wzx.pro.question.tik.hot;

import com.wzx.pro.question.tik.TreeNode;

import java.util.Stack;

public class Q33_101_对称二叉树 {

    private static boolean solution(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        if (root.left != null && root.right != null) {
            leftStack.push(root.left);
            rightStack.push(root.right);
        } else if (root.left != null || root.right != null) {
            return false;
        }

        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            TreeNode leftVal = leftStack.pop();
            TreeNode rightVal = rightStack.pop();
            if (leftVal.val != rightVal.val) {
                return false;
            }
            if (leftVal.left != null && rightVal.right != null) {
                leftStack.push(leftVal.left);
                rightStack.push(rightVal.right);
            } else if (leftVal.left != null || rightVal.right != null) {
                return false;
            }

            if (leftVal.right != null && rightVal.left != null) {
                leftStack.push(leftVal.right);
                rightStack.push(rightVal.left);
            } else if (leftVal.right != null || rightVal.left != null) {
                return false;
            }
        }
        return true;
    }

    private static boolean solution2(TreeNode root) {
        return check(root.left,root.right);
    }

    private static boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val==node2.val && check(node1.left,node2.right) && check(node1.right,node2.left);
    }

}
