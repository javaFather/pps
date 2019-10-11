package com.wzx.pro.domain.customer;

import lombok.Data;

@Data
public class CusInfo {
    //姓名
    private String name;
    //手机号
    private String phone;
    //身份证
    private String idno;

    private String city;

    private String prov;
}
