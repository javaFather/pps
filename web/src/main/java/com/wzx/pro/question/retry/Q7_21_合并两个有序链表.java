package com.wzx.pro.question.retry;

public class Q7_21_合并两个有序链表 {

    private static ListNode solution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode pre = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = null == l1 ? l2 : l1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(7);
        ListNode aNode1 = new ListNode(1);
        ListNode aNode2 = new ListNode(2);
        ListNode aNode3 = new ListNode(3);
        ListNode bNode1 = new ListNode(8);
        ListNode bNode2 = new ListNode(9);
        headA.next = aNode1;
        aNode1.next = aNode2;
        aNode2.next = aNode3;
        headB.next = bNode1;
        bNode1.next = bNode2;
        ListNode solution = solution(headA, headB);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }


}
