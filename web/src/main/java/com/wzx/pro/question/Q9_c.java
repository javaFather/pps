package com.wzx.pro.question;

import java.util.Stack;

public class Q9_c {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public Q9_c(){
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void  push(int val){
        inStack.push(val);
    }

    public int pop(){
        if(outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek(){
        if(outStack.isEmpty()){
            while (inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean isEmpty(){
        if(inStack.isEmpty() && outStack.isEmpty()) {
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        Q9_c queue = new Q9_c();
        queue.push(1);
        queue.push(2);
        while (!queue.isEmpty()){
            System.out.println(queue.pop());
        }


    }
}
