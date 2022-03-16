package com.wzx.pro.question.tik;

import java.util.HashMap;
import java.util.Map;

public class Q22_146_LRU缓存 {

    private static class LRUCache {
        //容量
        private int pacacity;
        //key-value键值对
        private Map<Integer, Integer> map = new HashMap<>();
        //访问次数-与key关系

        private LRUCache(int capacity) {
            this.pacacity = capacity;
        }


        private int get(int key) {
            if (map.get(key) != null) {
                //访问次数+1

                return map.get(key);
            }

            return 0;
        }

        private void put(int key, int value) {

        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        System.out.println(lruCache.pacacity);
    }

}
