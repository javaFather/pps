package com.wzx.pro.common.demo;

public class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();

    }
    public void run(){
        try{
            sleep(duration );
        }catch (Exception e){
            System.out.println(getName()+"was 打断"+isInterrupted());
        }
        System.out.println(getName()+"has awakened");
    }
}
