package com.wzx.pro.question.tik;

import java.util.Stack;

public class Q20_143_重排链表 {
        public static void reorderList(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode pre = head;
            ListNode cur = head;
            while(pre!=null){
                stack.add(pre);
                pre=pre.next;
            }

            while(cur!=null){
                if(cur==stack.peek()){

                }
                if(cur!=stack.peek()){
                    ListNode  node = stack.pop();
                    node.next = cur.next;
                    cur.next = node;
                    cur = cur.next.next;
                }else{
                    cur.next=null;
                    return ;
                }
            }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
//        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
//        head4.next = head5;
        reorderList(head1);
        while (head1 != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }
    }

    private static ListNode solution2(ListNode head){
        ListNode pre = head;
        ListNode cur =head;
        Stack<ListNode> stack = new Stack<>();
        while (pre!=null){
            stack.push(pre);
            pre = pre.next;
        }

        ListNode pop = new ListNode();
        while (cur.next!=pop.next){
            pop = stack.pop();
            pop.next=cur.next;
            cur.next=pop;
            cur =cur.next.next;

        }
        pop.next=null;
        return head;
    }
}
