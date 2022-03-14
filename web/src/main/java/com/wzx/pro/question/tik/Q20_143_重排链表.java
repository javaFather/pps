package com.wzx.pro.question.tik;

import java.util.Stack;

public class Q20_143_重排链表 {

    private static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (pre !=null && pre.next!=null) {
            while (pre.next.next != null) {
                pre = pre.next;
            }

            ListNode item = pre.next;
            pre.next=null;
            item.next=cur.next;
            cur.next=item;
            pre = cur.next.next;
            cur = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode solution = solution2(head1);
        while (solution != null) {
            System.out.println(solution.val);
            solution = solution.next;
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
