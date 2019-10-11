package com.wzx.pro.common.demo;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {

        return "res+ult of taskWithResult"+id;
    }

}
