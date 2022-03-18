package com.wzx.pro.question.tik.hot;

import java.util.HashMap;
import java.util.Map;

public class Q22_146_LRU缓存 {

    private static class LRUCache {

        private class LRUCacheNode {
            private Integer key;
            private Integer val;
            private LRUCacheNode pre;
            private LRUCacheNode next;

            public LRUCacheNode() {
            }

            public LRUCacheNode(Integer key, Integer val) {
                this.key = key;
                this.val = val;

            }
        }


        //容量
        private int pacacity;
        //key-value键值对
        private Map<Integer, LRUCacheNode> map = new HashMap<>();
        //访问次数-与key关系
        LRUCacheNode head;
        LRUCacheNode foot;
        //当前大小
        private int size;

        private LRUCache(int capacity) {
            this.pacacity = capacity;
            head = new LRUCacheNode();
            foot = new LRUCacheNode();
            head.next = foot;
            foot.pre = head;
            size = 0;

        }


        /**
         * 查询
         *
         * @param key
         * @return
         */
        private int get(int key) {
            LRUCacheNode cur = map.get(key);
            if (cur == null) {
                return -1;
            }
            //删除节点
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            //添加到头
            cur.next = head.next;
            head.next.pre = cur;
            head.next = cur;
            cur.pre = head;
            return cur.val;
        }

        /**
         * 插入
         *
         * @param key
         * @param value
         */
        private void put(int key, int value) {
            LRUCacheNode node = new LRUCacheNode(key, value);
            LRUCacheNode cur = map.get(key);
            if (cur == null) {
                node.next = head.next;
                head.next.pre = node;
                head.next = node;
                node.pre = head;
                map.put(key, node);
                ++size;
                //移除最尾端元素
                if (size > pacacity) {
                    LRUCacheNode pre = foot.pre;
                    pre.pre.next = foot;
                    foot.pre = pre.pre;
                    map.remove(pre.key);
                    --size;
                }
            } else {
                cur.val = value;
                //删除节点
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
                //添加到头
                cur.pre = head;
                cur.next = head.next;
                head.next.pre = cur;
                head.next = cur;
                map.put(key, cur);
            }

        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,3);
        lruCache.put(1,3);
        lruCache.put(3,3);
    }

}
