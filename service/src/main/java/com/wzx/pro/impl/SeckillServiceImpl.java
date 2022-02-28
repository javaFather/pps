package com.wzx.pro.impl;

import com.wzx.pro.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Slf4j
@Service
public class SeckillServiceImpl implements SeckillService {
    @Override
    public String testAop() {
        String s = new String();
        s = "测试动态代理";
        return s ;
    }
}
