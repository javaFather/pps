package com.wzx.pro.question;

public class BananaLinkList {

    private class ListNode {
        private ListNode next;
        private ListNode now;
    }

    public ListNode getListNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = null == pA ? pB : pA.next;
            pB = null == pB ? pA : pB.next;
        }
        return pA;
    }
}
