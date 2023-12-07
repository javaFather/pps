package com.wzx.pro.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class BaseDomain implements Serializable {
    public BaseDomain() {
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
