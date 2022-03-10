package com.wzx.pro.question.tik;

public class Q4_110_平衡二叉树 {
    private static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = avl(root);
        return true;
    }

    private static int avl(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = avl(root.left);
        int rightDepth = avl(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_left_1 = new TreeNode(2);
        TreeNode root_right_1 = new TreeNode(3);
        TreeNode root_left_1_1 = new TreeNode(4);
        TreeNode root_left_1_2 = new TreeNode(5);
        TreeNode root_right_2_2 = new TreeNode(6);
        TreeNode root_right_2_3 = new TreeNode(7);
        TreeNode root_right_2_4 = new TreeNode(8);
        root.left = root_left_1;
        root.right = root_right_1;
        root_left_1.left = root_left_1_1;
        root_left_1.right = root_left_1_2;
        root_right_1.right = root_right_2_2;
        root_right_2_2.right = root_right_2_3;
        root_right_2_3.right = root_right_2_4;

        boolean solution = solution(root);
        System.out.println(solution);
    }

}
