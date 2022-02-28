package com.wzx.pro.question;

import java.util.Stack;

public class StackRealizeQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public StackRealizeQueue() {
        inStack = new Stack<>(); // 负责进栈
        outStack = new Stack<>(); // 负责出栈
    }

    public void push(int x) {
        inStack.push(x);
    }
    public int pop() {
        dumpStack1();
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        dumpStack1();
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // 如果stack2为空，那么将stack1中的元素全部放到stack2中
    private void dumpStack1(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {

    }

}
