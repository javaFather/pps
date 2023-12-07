package com.wzx.pro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author wangzx
 * @date 2019/5/22 10:00
 *
 */
@SpringBootApplication(exclude = SpringBootConfiguration.class)
@Slf4j
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        log.info("==============WebApplication Start Success=====================");
    }

}
