package com.wzx.pro.controller;

public class LockTest {
    private class A {

    }

    private class B {

    }
        public static void main(String[] args) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (B.class) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (A.class) {

                        }
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (A.class) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        synchronized (B.class) {

                        }
                    }

                }
            }).start();
        }

    }

