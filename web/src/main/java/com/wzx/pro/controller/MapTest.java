package com.wzx.pro.controller;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("","");

        HashMap map1 = new  HashMap();
        map1.put("","");
        map1.get("");
    }
}
