package com.wzx.pro.common.demo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = Lists.newArrayList();
        for(int i=0;i<10;i++){
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for(Future<String> string :results){
            try {
                System.out.println(string.get());

            }catch (Exception e){

            }

        }

    }
}
