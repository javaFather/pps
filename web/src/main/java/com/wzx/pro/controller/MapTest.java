package com.wzx.pro.controller;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("","");

        HashMap map1 = new  HashMap();
        map1.put("1","2");
        map1.put("3","4");
        Object o = map1.get("1");
        System.out.println(o);
    }
}
