package com.wzx.pro.question.tik.hot;


import com.wzx.pro.question.tik.ListNode;

public class Q23_206_翻转链表 {
    private static ListNode solution(ListNode pre){
        ListNode result = null;
        while (pre!=null){
            ListNode next = pre.next;
            pre.next = result;
            result = pre;
            pre = next;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head.next =head2;
        head2.next=head3;
        ListNode solution = solution(head);
        while (solution!=null){
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
