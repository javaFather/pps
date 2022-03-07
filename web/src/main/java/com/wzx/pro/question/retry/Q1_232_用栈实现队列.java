package com.wzx.pro.question.retry;

import java.util.Stack;

public class Q1_232_用栈实现队列 {

    public static class MyQueue {

        private Stack<Integer> input = new Stack<>();

        private Stack<Integer> output = new Stack<>();

        private void push(int val) {
            input.push(val);
        }


        private int peek() {
            if (!output.isEmpty()) {
                return output.peek();
            }
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.peek();
        }


        private int pop() {
            if (!output.isEmpty()) {
                return output.pop();
            }
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.pop();
        }

        private boolean isEmpty() {
            return (input.isEmpty() && output.isEmpty());
        }

    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        while (!myQueue.isEmpty()){
            System.out.println("peek==="+myQueue.peek());
            System.out.println("pop==="+myQueue.pop());
        }
    }

}
