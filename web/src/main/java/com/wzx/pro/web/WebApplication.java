package com.wzx.pro.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 * @author wangzx
 * @date 2019/5/22 10:00
 *
 */
@MapperScan(basePackages = "com.wzx.pro.dao")
@SpringBootApplication
@Slf4j
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        log.info("==============WebApplication Start Success=====================");
    }

}
