package com.wzx.pro.domain.trade;

import org.apache.commons.lang3.StringUtils;

import java.util.Hashtable;
import java.util.Objects;

public class Hash {
    public MyHash[] arry;

    private class MyHash{
        private int idnex;
        private String key;
        private String value;
        private MyHash[] arry;
    }

    public Hash(int size){
        arry = new MyHash[size];
    }



    //查询
    public String query(String key){
        Integer address = key.hashCode()%100;
        if(address>arry.length){
            return null;
        }else {
            MyHash myHash = arry[address];
            if(Objects.isNull(myHash)){
                return null;
            }
            if(!Objects.isNull(myHash) && key.equals(myHash.key)){
                return myHash.value;
            }else {
                MyHash[] arry = myHash.arry;
                if(arry.length>0){
                    for(MyHash hash:arry){
                        if(key.equals(hash.key)){
                            return hash.value;
                        }
                    }
                }

                return null;
            }
        }

    }
    //插入
    public void insert(String key,String value){
        Integer address = key.hashCode()%100;
        //hash值超过数组size的80%，扩容当前最大index的两倍
        if (address>=arry.length*0.8){
           arry = reSize(address,arry,key,value);
        }else {
            //hash冲突再hash，直到不冲突
            if (StringUtils.isNoneBlank(arry[address].key)) {
                crash(arry,address,key,value);
            }
        }

    }
    //解决冲突

    private void crash(MyHash[] hash,int address,String key,String value){
        MyHash hash1 = hash[address];
        MyHash hash2 = new MyHash();
        hash2.key= key;
        hash2.value = value;
        int length = hash1.arry.length;
        hash1.arry[length+1]= hash2;
    }

    //扩容
    private MyHash[] reSize(int address,MyHash[] arry,String key,String value) {
            MyHash[] str = new MyHash[2 * address];
            for (int i = 0; i < arry.length; i++) {
                str[i] = arry[i];
            }
            MyHash hash = new MyHash();
            hash.key = key;
            hash.value = value;
            str[address] = hash;
            return str;
    }

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.entrySet();
    }
}
