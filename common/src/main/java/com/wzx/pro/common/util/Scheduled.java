package com.wzx.pro.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhenxing
 * @description
 * @date 2021/4/20 15:48
 */
@Slf4j
public class Scheduled {

    private static volatile  int a = 1;

    public static void main(String[] args) throws Exception {
        Scheduled scheduled =new Scheduled();
        scheduled.test1();
        Thread.sleep(10000);
        System.out.println(a);
    }

    private void test1(){
        ScheduledExecutorService DELAY_EXPORT_EXECUTOR =
                Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("DubboServiceDelayExporter", true));
        DELAY_EXPORT_EXECUTOR.schedule(this::test,5, TimeUnit.SECONDS);
    }

    private void test(){
        System.out.println("-------");
    }
}
