package com.wzx.pro.service.impl;

import com.wzx.pro.service.SpiService;
import org.springframework.stereotype.Service;

/**
 * @author wangzhenxing
 * @description
 * @date 2021/3/25 21:46
 */
@Service
public class RedSpiServiceImpl implements SpiService {

    @Override
    public void sayHello() {
        System.out.println("红色spi实现");
    }
}
