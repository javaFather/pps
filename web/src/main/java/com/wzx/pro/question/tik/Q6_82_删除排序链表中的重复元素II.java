package com.wzx.pro.question.tik;

public class Q6_82_删除排序链表中的重复元素II {
    private static ListNode solution(ListNode head) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode pre = result;
        while (pre.next != null) {
            if (pre.val != pre.next.val) {
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

        ListNode solution = solution(head1);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
