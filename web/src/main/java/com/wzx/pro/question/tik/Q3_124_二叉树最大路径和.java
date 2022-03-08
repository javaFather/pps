package com.wzx.pro.question.tik;

public class Q3_124_二叉树最大路径和 {

    private static int max = Integer.MIN_VALUE;

    private static int solution(TreeNode root) {
        postOrder(root);
        return max;

    }

    private static int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(postOrder(root.left),0);
        int right = Math.max(postOrder(root.right),0);
        max = Math.max(max,root.val+left+right);
        return root.val+Math.max(left,right);

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

        int solution = solution(root);
        System.out.println(solution);
    }
}
