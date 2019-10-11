package com.wzx.pro.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.wzx.pro.common.util.HttpClientUtil;
import com.wzx.pro.dao.customer.CustomerInfoMapper;
import com.wzx.pro.domain.customer.CusInfo;
import com.wzx.pro.domain.customer.Query;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("queryController")
public class QueryController {
@Autowired
    CustomerInfoMapper customerInfoMapper;

    @RequestMapping("/query")
    @ResponseBody
    public String  query(){




        return "00";

    }

    public String  sendRequest(String phone){
        long l = System.currentTimeMillis();
        Map map = Maps.newHashMap();
        map.put("cb", "jQuery110205200907786567581_1568250971991");
        map.put("resource_name", "guishudi");
        map.put("_", l + "");
        map.put("query", phone);
        String s = HttpClientUtil.doGet("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php", map, "utf-8");
        return s;
    }

    public void getCity(String str,CusInfo info){
        if(StringUtils.isNotEmpty(str)) {
            int i = str.indexOf("[");
            String obj = str.substring(i + 1);
            String json = obj.substring(0, obj.length() - 4);
            JSONObject jsonObject = JSON.parseObject(json);
            String city = jsonObject.getString("city");
            String prov = jsonObject.getString("prov");
            info.setCity(city);
            info.setProv(prov);
        }
    }

}
