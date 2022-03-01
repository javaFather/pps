package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Queue;

public class Q117_填充每个节点的下一个右侧节点指针II {

    public static MyNode solutiion(MyNode node) {
        if (node == null) {
            return null;
        }
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            MyNode pre = null;
            for(int i =0;i<size;i++){
                MyNode cur = queue.poll();
                if(cur.left !=null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }

                if(i>1){
                    pre.next = cur;
                }
                pre =cur;
            }

        }

        return node;
    }

    public static void main(String[] args) {
        MyNode root = new MyNode(1);
        MyNode root_left_1 = new MyNode(2);
        MyNode root_right_1 = new MyNode(3);
        MyNode root_left_1_1 = new MyNode(4);
        MyNode root_left_1_2 = new MyNode(5);
        MyNode root_right_2_2 = new MyNode(6);
        root.left = root_left_1;
        root.right = root_right_1;
        root_left_1.left = root_left_1_1;
        root_left_1.right = root_left_1_2;
        root_right_1.right = root_right_2_2;
        MyNode a = solutiion(root);
        System.out.println(JSON.toJSONString(a));
    }
}
