package com.wzx.pro.question;

public class Q19_c {

    public static ListNode solution(ListNode root, int index) {
        ListNode slow = root;
        ListNode fast = root;
        int step = 0;
        while (fast.next != null) {
            fast = fast.next;
            if (step >= index) {
                slow = slow.next;
            }
            step++;
        }
        slow.next =slow.next.next;
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(4);
        root.next = root2;
        root2.next = root3;
        root3.next = root4;
        ListNode solution = solution(root, 2);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
