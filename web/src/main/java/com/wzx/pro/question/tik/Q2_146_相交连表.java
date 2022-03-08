package com.wzx.pro.question.tik;

public class Q2_146_相交连表 {

    private static ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode headA = l1;
        ListNode headB = l2;
        while (headA != headB) {
            headA = null == headA ? l2 : headA.next;
            headB = null == headB ? l1 : headB.next;
        }

        return headA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(10);
        ListNode aNode1 = new ListNode(1);
        ListNode aNode2 = new ListNode(2);
        ListNode aNode3 = new ListNode(3);
        ListNode bNode1 = new ListNode(9);
        ListNode bNode2 = new ListNode(8);
        headA.next = aNode1;
        aNode1.next = aNode2;
        aNode2.next = aNode3;
        headB.next = bNode1;
        bNode1.next = bNode2;
        bNode2.next = aNode1;
        ListNode solution = solution(headA, headB);
        System.out.println(solution == null ? solution : solution.val);
    }
}
