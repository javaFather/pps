package com.wzx.pro.question;

import java.util.Objects;

public class DelRepeatNode {

    public static ListNode solutioin(ListNode head){
        if(head ==null){
            return head;
        }

        ListNode cur = head;
        ListNode pre = cur;
        Integer val =null ;
        while (cur.next !=null){
            if(Objects.isNull(val)){
                val  = cur.val;
            }

            ListNode next = cur.next;
            if(val == next.val){
                pre = next.next;
                cur.next=null;
                cur =pre;
            }else {
                val  = next.val;
                cur = next;
            }

        }

        return pre;
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
        ListNode solutioin = solutioin(head);
        System.out.printf("====");
    }
}
