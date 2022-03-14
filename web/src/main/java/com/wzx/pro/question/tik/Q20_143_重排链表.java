package com.wzx.pro.question.tik;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q20_143_重排链表 {

    private static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        int num = 0;
        Queue<ListNode> queue = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();
        ListNode result = new ListNode();
        result.next = head;
        ListNode pre = result.next;

        while (head != null) {
            head = head.next;
            if (num % 2 == 0) {
                queue.offer(head);
            } else {
                stack.push(head);
            }
            num++;
        }

        while (!queue.isEmpty() || !stack.isEmpty()) {
            if (!stack.isEmpty()) {
                pre.next = stack.pop();
                pre = pre.next;
            }
            if (!queue.isEmpty()) {
                pre.next = queue.poll();
                pre = pre.next;
            }


        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode solution = solution(head1);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
