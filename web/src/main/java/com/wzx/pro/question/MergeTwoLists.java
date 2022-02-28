package com.wzx.pro.question;

public class MergeTwoLists {

    private class ListNode {
        private ListNode prev;
        private ListNode next;
        private int val;
    }

    private ListNode solution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode prev = result;

        while (l1 != null && null != l2) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return result.next;
    }
}
