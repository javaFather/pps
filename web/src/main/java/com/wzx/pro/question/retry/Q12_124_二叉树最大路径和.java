package com.wzx.pro.question.retry;

public class Q12_124_二叉树最大路径和 {
    private static int max = Integer.MIN_VALUE;

    private static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        invoke(root);
        return max;
    }

    private static int invoke(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(invoke(root.left), 0);
        int right = Math.max(invoke(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
