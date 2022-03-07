package com.wzx.pro.question.retry;

public class Q2_160_相交链表 {

    private static ListNode solution(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;
        while (preA != preB) {
            preA = null == preA ? headB : preA.next;
            preB = null == preB ? headA : preB.next;
        }
        return preA;
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
//        bNode2.next = aNode1;
        ListNode solution = solution(headA, headB);
        System.out.println(solution==null?solution:solution.val);
    }
}
