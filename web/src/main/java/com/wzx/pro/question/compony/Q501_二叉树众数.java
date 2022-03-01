package com.wzx.pro.question.compony;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class Q501_二叉树众数 {

    private static List<Integer> solution(TreeNode root){
        if(root ==null){
            return Lists.newArrayList();
        }
        TreeNode cur = root;
        List<Integer> result = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                result.add(cur.val);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            cur = pop.right;
        }


        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root_left_1 = new TreeNode(2);
        TreeNode root_right_1 = new TreeNode(2);
        TreeNode root_left_1_1 = new TreeNode(4);
        TreeNode root_left_1_2 = new TreeNode(4);
        TreeNode root_right_2_2 = new TreeNode(6);
        root.left = root_left_1;
        root.right = root_right_1;
        root_left_1.left = root_left_1_1;
        root_left_1.right = root_left_1_2;
        root_right_1.right = root_right_2_2;
        List<Integer> solution = solution(root);
        System.out.println(JSON.toJSONString(solution));
    }
}
