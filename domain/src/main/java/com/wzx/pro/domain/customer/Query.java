package com.wzx.pro.domain.customer;

import lombok.Data;

@Data
public class Query {
    //姓名
    private String PAYER_NAME;
    //手机号
    private String PAYER_MOBILE;
    //身份证
    private String PAYER_ID;

    private String CITY;
}
