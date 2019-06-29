package com.wzx.pro.controller;

import com.wzx.pro.common.util.Result;
import com.wzx.pro.service.PIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 交易入口
 */
@RestController
@RequestMapping("/tradeController")
public class TradeController {
    @Autowired
    PIService pIService;
    /**
     * 计算π的值
     */
    @RequestMapping("/getPI")
   public  void getPI(){
        pIService.getPI();

   }

   public Result<String> seckillPortController(){
        return null;
   }
}
