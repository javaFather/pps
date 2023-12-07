package com.wzx.pro.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
        public class Node{
            private Node pre;
            private Node next;
            private Integer key;
            private Integer value;

            public Node(){}
            public Node(int key,int value){
                this.key =key;
                this.value = value;
            }
        }

        private Map<Integer,Node> map;
        private Node start;
        private Node end;
        private int capacity;
        private int size;


        public LRUCache(int capacity) {
            this.capacity =capacity;
            map=new HashMap<>();
            start=new Node();
            end=new Node();
            start.next=end;
            end.pre=start;
        }

        public int get(int key) {

            Node node = map.get(key);
            if(node==null){
                return -1;
            }
            node.pre.next=node.next;
            node.next.pre=node.pre;
            node.next=start.next;
            start.next.pre=node;
            node.pre=start;
            start.next=node;
            map.put(key,node);
            return node.value;

        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if(node!=null){
                node.pre.next =node.next;
                node.next.pre = node.pre;
                node.next=start.next;
                node.pre =start;
                map.put(key,node);

            }else{

                if(size>=capacity){
                    end.pre.pre.next =end;
                    end.pre =end.pre.pre;
                    map.remove(end.pre.key);
                    size++;

                }
                node =new Node(key,value);
                node.next=start.next;
                start.next.pre =node;
                node.pre=start;
                start.next=node;
                size++;
                map.put(key,node);


            }


        }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        List<Integer> item = new ArrayList<>();


    }

}
