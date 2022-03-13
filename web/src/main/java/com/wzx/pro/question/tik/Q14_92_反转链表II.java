package com.wzx.pro.question.tik;

public class Q14_92_反转链表II {

    private static ListNode solution(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode result = new ListNode();
        result.next = head;
        ListNode pre = result;
        int leftStep = 1;
        while (left > leftStep) {
            pre = pre.next;
            leftStep++;
        }
        ListNode cur = pre.next;
        ListNode next;
        while (right - left > 0) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            left++;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode solution = solution(head, 2, 4);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }


}
