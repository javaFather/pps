package com.wzx.pro.question.home;

public class Q19_删除链表的倒数第N个结点 {

    public static ListNode solution(ListNode node, int index) {

        ListNode pre = node;
        ListNode last = node;
        while (index > 0) {
            last = last.next;
            index--;
        }

        while (last.next!=null){
            pre = pre.next;
            last =last.next;
        }
        pre.next= pre.next.next;
        pre.next.next =null;
        return node;
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
        ListNode solution = solution(head, 2);
        while(solution !=null){
            System.out.println(solution.val);
            solution = solution.next;

        }
    }
}
