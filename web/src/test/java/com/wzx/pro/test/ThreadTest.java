package com.wzx.pro.test;

public class ThreadTest {
    private static volatile int index = 1;
    private static final Object obj = new Object();
    static class MyThread implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                while (index <= 100) {
                    obj.notify();
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "*****" + index);
                    index++;
                    try{
                        obj.wait();
                    }catch (Exception e){
                    }
                }
                obj.notifyAll();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread(),"t1");
        Thread t2 = new Thread(new MyThread(),"t2");
        t1.start();
        t2.start();

    }
}
