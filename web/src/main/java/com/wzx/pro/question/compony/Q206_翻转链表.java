package com.wzx.pro.question.compony;

public class Q206_翻转链表 {

    private static ListNode solution(ListNode root){
        ListNode cur = root;
        ListNode result = null;
        while (cur !=null){
            ListNode next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode head2 = new ListNode(8);
        ListNode head3 = new ListNode(7);
        ListNode head4 = new ListNode(6);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode solution = solution(head);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
