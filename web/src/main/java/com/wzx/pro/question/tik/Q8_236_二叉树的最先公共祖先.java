package com.wzx.pro.question.tik;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class Q8_236_二叉树的最先公共祖先 {
    private static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = root;
        List<Integer> treeList = Lists.newArrayList();
        while (pre != null || !stack.isEmpty()) {
            while (pre != null) {
                stack.push(pre.left);
                pre = pre.left;
            }
            TreeNode pop = stack.pop();
            int val = pop.val;
            pre = pop.right;
            treeList.add(val);
        }
        return root;
    }

}
