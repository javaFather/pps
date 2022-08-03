package com.wzx.pro.question.tik.hot;

import com.alibaba.fastjson.JSON;
import com.wzx.pro.question.tik.TreeNode;

import java.util.*;

public class Q28_199_二叉树的右视图 {

    private static List<Integer> solution(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //记录深度
        Map<TreeNode, Integer> map = new HashMap<>();
        //深度有没有放过
        Map<Integer, Integer> existMap = new HashMap<>();
        queue.offer(root);
        map.put(root, 1);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            Integer integer = map.get(cur);
            if (existMap.get(integer) == null) {
                existMap.put(integer, integer);
                result.add(cur.val);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                map.put(cur.right, integer + 1);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
                map.put(cur.left, integer + 1);
            }


        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left_1 = new TreeNode(9);
        TreeNode right_1 = new TreeNode(20);
        TreeNode left_2 = new TreeNode(15);
        TreeNode right_2 = new TreeNode(7);
        root.left = left_1;
        root.right = right_1;
        left_1.left = left_2;
        left_1.right = right_2;
        List<Integer> solution = solution2(root);
        System.out.println(JSON.toJSONString(solution));
    }

    private static List<Integer> solution2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = result.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                if (result.size() == count) {
                    result.add(cur.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                size--;
            }


        }

        return result;
    }


}
