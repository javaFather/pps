package com.wzx.pro.controller.leetcode;

public class TwoSum {

    public static ListNode solution(ListNode l1, ListNode l2) {

        ListNode start = new ListNode();
        ListNode cur = start;
        int step = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sums = x + y + step;
            step = sums / 10;
            int last = sums % 10;
            ListNode newNode = new ListNode(last);
            cur.next = newNode;
            cur = cur.next;

            l1 = l1.next != null ? l1.next : null;
            l2 = l2.next != null ? l2.next : null;

        }
        if (step > 0) {
            cur.next = new ListNode(step);

        }

        return start.next;
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

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(2);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(4);
        ListNode l25 = new ListNode(5);
        l2.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        ListNode result = solution(head, l2);

    }
}


