package com.wzx.pro.question;


public class ListReverse {
    public static  ListNode reverseList(ListNode head){
        ListNode result = null;
        ListNode sy ;
        while (head !=null){
           sy = head.next;
           head.next =null;
           ListNode cur  = head;
           cur.next =result;
           result = cur;
           head =sy;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next =head2;
        head2.next=head3;
        head3.next = head4;
        head4.next=head5;



       ListNode listNode = reverseList(head);
       while (listNode !=null){
           System.out.printf(listNode.val+"**");
           listNode = listNode.next;
       }
   }
}
