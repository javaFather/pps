package com.wzx.pro.question.tik.hot;

import com.wzx.pro.question.tik.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Q31_141_环形链表 {

    private static boolean solution(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        Map<ListNode, Integer> map = new HashMap<>();
        while (fast != null) {
            if (map.containsKey(fast)) {
                return true;
            }
            map.put(fast, 1);
            fast = fast.next;
        }
        return false;
    }

    private static boolean solution2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);

//        ListNode head3 = new ListNode(3);
//        ListNode head4 = new ListNode(4);
        head.next = head2;
//        head2.next = head3;
//        head3.next = head4;
//        head4.next = head2;
        boolean solution = solution(head);
        boolean solution2 = solution2(head);
        System.out.println(solution);
        System.out.println(solution2);

    }
}
