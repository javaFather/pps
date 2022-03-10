package com.wzx.pro.question.tik;

public class Q10_129_求根节点到叶节点数字之和 {
    private static int sum = 0;

    private static int solution(TreeNode root) {
        back(root, "");
        return sum;
    }

    private static void back(TreeNode root, String val) {
        if (root == null) {
            sum = sum + Integer.parseInt(val);
        }
        back(root.left, val + root.val);
        back(root.right, val + root.val);

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
