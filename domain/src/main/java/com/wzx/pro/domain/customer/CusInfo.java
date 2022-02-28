package com.wzx.pro.domain.customer;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

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

    public static void main(String[] args) {

                int a = 4241;
                List<String> list = Lists.newArrayList();
                for(int i=0;i<=150;i++){
                    int b =a+2;
                    a=b;
                    String str = b+" 所函 0702";
                    System.out.println(str);

                }

            }



}
