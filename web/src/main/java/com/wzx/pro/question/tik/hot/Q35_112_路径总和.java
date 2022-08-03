package com.wzx.pro.question.tik.hot;

import com.wzx.pro.question.tik.TreeNode;

public class Q35_112_路径总和 {

    private static boolean solution(TreeNode root, int target) {

        return check(root, 0, target);
    }

    private static boolean check(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }
        sum = sum + root.val;
        if (root.left == null && root.right == null && sum == target) {
            return true;
        }
        return check(root.left, sum, target) || check(root.right, sum, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
//        TreeNode left_1 = new TreeNode(2);
        TreeNode right_1 = new TreeNode(-3);
//        TreeNode left_2 = new TreeNode(4);
//        TreeNode right_2 = new TreeNode(5);
//        root.left = left_1;
        root.right = right_1;
//        right_1.left = left_2;
//        right_1.right = right_2;
        boolean solution = solution(root, -5);
        System.out.println(solution);
    }
}
