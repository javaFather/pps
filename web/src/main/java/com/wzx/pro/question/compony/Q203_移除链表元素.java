package com.wzx.pro.question.compony;

public class Q203_移除链表元素 {

    private static ListNode solution(ListNode root, int val) {
        ListNode result = new ListNode();
        result.next = root;
        ListNode pre = result;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode head2 = new ListNode(9);
        ListNode head3 = new ListNode(8);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode solution = solution(head, 8);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
