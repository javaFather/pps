package com.wzx.pro.question.retry;

public class Q4_2_两数相加 {

    private static ListNode solutioin(ListNode l1, ListNode l2) {
        int step = 0;
        int num = 0;
        ListNode result = new ListNode();
        ListNode pre = result;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + step;
            step = sum / 10;
            num = sum % 10;
            ListNode item = new ListNode(num);
            pre.next = item;
            pre = pre.next;
            if(l1!=null){
                l1 = l1.next;
            }

            if(l2!=null){
                l2 = l2.next;
            }
        }

        if (step > 0) {
            ListNode item = new ListNode(num);
            pre.next = item;
        }
        return result.next ;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(9);
        ListNode head3 = new ListNode(3);
        head.next = head2;
        head2.next = head3;

        ListNode root = new ListNode(5);
        ListNode root2 = new ListNode(8);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(2);
        root.next = root2;
        root2.next = root3;
        root3.next = root4;
        ListNode solutioin = solutioin(head, root);
        while (solutioin != null) {
            System.out.println(solutioin.val);
            solutioin = solutioin.next;
        }
    }
}
