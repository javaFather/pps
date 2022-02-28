package com.wzx.pro.question;

public class Q21_c {

    public static ListNode solution(ListNode l1, ListNode l2) {
       if(l1==null){
           return l2;
       }else if(l2==null){
            return l1;
       }else if(l1.val<l2.val){
           l1.next = solution(l1.next,l2);
           return l1;
       }else {
           l2.next =solution(l1,l2.next);
           return l2;
       }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode root2 = new ListNode(3);
//        ListNode root3 = new ListNode(3);
        root.next = root2;
//        root2.next = root3;

        ListNode head = new ListNode(2);
        ListNode head2 = new ListNode(5);
//        ListNode head3 = new ListNode(9);
        head.next = head2;
//        head2.next = head3;

        ListNode solution = solution(root, head);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
