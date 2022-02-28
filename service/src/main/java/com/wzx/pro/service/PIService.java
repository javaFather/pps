package com.wzx.pro.service;

import com.wzx.pro.task.PITask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @author wangzxs
 * @date 2019/5/24 18:17:51
 */
@Slf4j
@Service
public class PIService {

    @Autowired
    SeckillService seckillService;
    /**
     * 计算π
     */
    public  void getPI(){
        ForkJoinPool pool = new ForkJoinPool(4);
        PITask task = new PITask(0,999_999_999,10_000_000);
        Double reult = pool.invoke(task);
        log.info("计算π的值的结果为π：{}",reult);

    }

    public String getResult (){
        String s = seckillService.testAop();
        log.info("会打赢");

        HashMap hashMap = new HashMap();

        return s;
    }
}
