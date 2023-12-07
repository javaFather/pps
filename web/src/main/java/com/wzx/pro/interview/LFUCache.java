package com.wzx.pro.interview;

import java.util.*;

public class LFUCache {

    private class Node {
        private Node pre;
        private Node next;
        private int key;
        private int value;
        private int count;

        public Node(){}
        private Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity;
    private Node head;
    private Node end;
    private Map<Integer,Node> map;
    private int size;


    public LFUCache(int capacity) {
        this.capacity =capacity;
        head = new Node();
        head.count=Integer.MIN_VALUE;
        end = new Node();
        end.count=Integer.MAX_VALUE;
        head.next =end;
        end.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node hisNode = map.get(key);
        if(Objects.isNull(hisNode)){
            return -1;
        }
        hisNode.count = hisNode.count+1;
        Node cur = hisNode.next;
        while(cur.count<=hisNode.count){
            cur = cur.next;
        }
        hisNode.pre.next= hisNode.next;
        hisNode.next.pre = hisNode.pre;
        cur.pre.next=hisNode;
        hisNode.pre =cur.pre;
        hisNode.next=cur;
        cur.pre=hisNode;
        return hisNode.value;
    }

    public void put(int key, int value) {
        Node hisNode = map.get(key);
        if(!Objects.isNull(hisNode)){
            hisNode.value=value;
        }else{
            if(capacity<=size){
                Node removeNode = head.next;
                head.next=removeNode.next;
                removeNode.next.pre = head;
                map.remove(removeNode.key);
                size--;
            }
            Node item = new Node(key,value);
            Node cur = head.next;
            while(cur.count<=item.count){
                cur=cur.next;
            }
            cur.pre.next=item;
            item.pre =cur.pre;
            item.next =cur;
            cur.pre =item;
            map.put(key,item);
            size++;
        }

    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.put(3,3);
        lfuCache.get(2);
        Queue<Integer> queue = new PriorityQueue<>();
    }
}
