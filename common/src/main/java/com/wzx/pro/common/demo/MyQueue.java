package com.wzx.pro.common.demo;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
    //需要一个橙装元素的集合
    private  LinkedList<Object> list = new LinkedList<>();

    //需要一个计数器，统计加入list的个数
    private AtomicInteger count = new AtomicInteger(0);

    //需要指定上下限限制，模拟有容量大小的容器
    private final int minSize =0;

    private final int maxSize;
    //构造方法
    public MyQueue(int size){
        this.maxSize = size;

    }

    //初始化一个对象用于枷锁
    private final Object lock = new Object();

    public void put(Object obj){
        synchronized (lock){
            try {
                //当前容器满了
                while (this.maxSize==count.get()){
                    lock.wait();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        //添加新元素
        list.add(obj);
        //计数器累加
        count.incrementAndGet();
        //唤醒其他线程
        System.out.println("新加入的元素"+obj);
        lock.notify();

    }

    public Object take(){
        Object ret = null;
        synchronized (lock){
            while (count.get()==this.minSize){
                try{
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            //移除元素操作
            ret = list.removeFirst();
            //计数器递减
            count.decrementAndGet();
            //唤醒另外一个线程
            lock.notify();

        }

        return ret;
    }

    public int getSize(){
        return this.count.get();
    }

    public static void main(String[] args)  {
       final MyQueue  mq = new MyQueue(5);
        mq.put("a");
        mq.put("b");
        mq.put("c");
        mq.put("d");
        mq.put("e");

//        System.out.println("当前线程长度"+mq.getSize());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mq.put("12");
                mq.put("dd");
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Object take = mq.take();
                System.out.println("移除的元素为"+take);
                Object take1 = mq.take();
                System.out.println("第二次移除的元素为"+take1);
            }
        },"t2");
        try{

            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t2.start();
    }
}
