package com.wzx.pro.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Slf4j
@RequestMapping("queryController")
public class QueryController {
@Autowired
//    CustomerInfoMapper customerInfoMapper;

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
//        String s = HttpClientUtil.doGet("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php", map, "utf-8");
        return null;
    }

//    public void getCity(String str,CusInfo info){
//        if(StringUtils.isNotEmpty(str)) {
//            int i = str.indexOf("[");
//            String obj = str.substring(i + 1);
//            String json = obj.substring(0, obj.length() - 4);
//            JSONObject jsonObject = JSON.parseObject(json);
//            String city = jsonObject.getString("city");
//            String prov = jsonObject.getString("prov");
//            info.setCity(city);
//            info.setProv(prov);
//        }
//    }

}
