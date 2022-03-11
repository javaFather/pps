package com.wzx.pro.question.tik;

public class Q10_129_求根节点到叶节点数字之和 {

    private static int solution(TreeNode root) {
        return back(root, 0);
    }

    private static int back(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int sum = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return back(root.left, sum) + back(root.right, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root_left_1 = new TreeNode(9);
        TreeNode root_right_1 = new TreeNode(0);
        TreeNode root_left_1_1 = new TreeNode(5);
        TreeNode root_left_1_2 = new TreeNode(1);

        root.left = root_left_1;
        root.right = root_right_1;
        root_left_1.left = root_left_1_1;
        root_left_1.right = root_left_1_2;

        int solution = solution(root);
        System.out.println(solution);
    }
}
