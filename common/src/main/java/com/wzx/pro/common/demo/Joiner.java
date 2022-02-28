package com.wzx.pro.common.demo;

public class Joiner extends Thread {
    private Sleeper sleeper;
    private Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run(){
        try{
            sleeper.join();
        }catch (Exception e){
            System.out.println("打断了");
        }
        System.out.println(getName()+"join complete");
    }

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("sleeper",1500),
        grumpy = new Sleeper("grumpy",1500);
        Joiner dopey = new Joiner("dopey",sleeper),
                doc = new Joiner("doc",grumpy);
        grumpy.interrupt();
    }
}
