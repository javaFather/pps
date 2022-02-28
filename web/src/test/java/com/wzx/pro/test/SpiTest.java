package com.wzx.pro.test;

import com.wzx.pro.WebApplication;
import com.wzx.pro.service.SpiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author wangzhenxing
 * @description
 * @date 2021/3/26 14:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class SpiTest {

    @Test
    public void spiTest(){
        ServiceLoader<SpiService> spiLoader = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iteratorSpi=spiLoader.iterator();
        while (iteratorSpi.hasNext()){
            SpiService spiService=iteratorSpi.next();
            spiService.sayHello();
        }

    }

    @Test
    public void scheduledTest(){

    }

}
