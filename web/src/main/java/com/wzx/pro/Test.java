package com.wzx.pro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class Test {
    public static void main(String[] args) {
        String str = "[\n" +
                "                {\n" +
                "                    \"custom\":\"range_input\",\n" +
                "                    \"label\":\"自定义\",\n" +
                "                    \"value\":\"custom\",\n" +
                "                    \"key\":\"krr159\"\n" +
                "                }]";
        String str2 = "[\n" +
                "                {\n" +
                "                    \"custom\":\"range_input\",\n" +
                "                    \"value\":\"custom\",\n" +
                "                    \"label\":\"自定义\",\n" +
                "                    \"key\":\"krr159\"\n" +
                "                }]";

        JSONArray a1 = JSON.parseArray(str);
        JSONArray a2 = JSON.parseArray(str2);
        for (Object item :a1){
            boolean contains = a2.contains(item);
            System.out.println(contains);
        }
    }
}
