package com.wzx.pro.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 启动类
 * @author wangzx
 * @date 2019/5/22 10:00
 *
 */

@SpringBootApplication
@Slf4j
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        log.info("==============WebApplication Start Success=====================");
    }

}
