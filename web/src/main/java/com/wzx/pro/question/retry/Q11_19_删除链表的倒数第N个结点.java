package com.wzx.pro.question.retry;

public class Q11_19_删除链表的倒数第N个结点 {

    private static ListNode solution(ListNode head, int inex) {

        ListNode pre = head;
        ListNode fastPre = head;
        while (fastPre.next != null) {
            fastPre = fastPre.next;
            inex--;
            if (inex < 0) {
                pre = pre.next;
            }
        }

        pre.next = pre.next.next;

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode head2 = new ListNode(10);
        ListNode head3 = new ListNode(8);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(2);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        ListNode solution = solution(head, 2);
        while(solution !=null){
            System.out.println(solution.val);
            solution = solution.next;

        }
    }

}
