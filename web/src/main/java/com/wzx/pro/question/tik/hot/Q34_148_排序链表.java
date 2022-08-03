package com.wzx.pro.question.tik.hot;

import com.wzx.pro.question.tik.ListNode;

public class Q34_148_排序链表 {

    private static ListNode solution(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode min = head;
        ListNode curPre = min;
        ListNode cur = min.next;

        while (cur != null) {
            ListNode position = min;
            if (cur.val <= min.val) {
                //小于
                curPre.next = cur.next;
                cur.next = min;
                min = cur;
            } else {
                //大于
                while (min.val < cur.val) {
                    if (min.next.val >= cur.val) {
                        curPre.next = cur.next;
                        cur.next = min.next;
                        min.next = cur;
                        if (min.next == curPre.next) {
                            curPre = curPre.next;
                        }
                        break;
                    } else {
                        min = min.next;
                    }
                }
                min = position;
            }
            cur = curPre.next;
        }
        return min;
    }


    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList2(head);
        ListNode right = sortList2(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode head2 = new ListNode(5);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(0);
//        ListNode head6 = new ListNode(7);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
//        head5.next = head6;
        ListNode solution = solution(head);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
