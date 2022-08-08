package com.wzx.pro.controller.test;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread {

    private static volatile int flag =0;

    public static void main(String[] args) {
        ReentrantLock lock  = new ReentrantLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int temp = flag;
                System.out.println("吃早饭"+temp);
                while (flag ==0) {

                }
                System.out.println("吃晚饭"+temp);
            }

        }, "线程1：");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("吃中饭");
                try {
                    Thread.sleep(2000L);
                    flag = 1;
                } catch (Exception e) {

                }

            }

        }, "线程2：");

        thread.start();
        thread2.start();
        String a ="";
    }
}

