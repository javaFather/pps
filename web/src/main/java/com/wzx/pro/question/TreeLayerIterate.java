package com.wzx.pro.question;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Queue;

public class TreeLayerIterate {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = Lists.newArrayList();
        Queue<TreeNode> queue = Lists.newLinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List item = Lists.newArrayList();
            while (size > 0) {
                TreeNode node = queue.poll();
                item.add(node.val);
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                size--;
            }
            result.add(item);

        }

        return result;
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
        List solution = levelOrder(root);
        System.out.println(JSON.toJSONString(solution));

    }

}
