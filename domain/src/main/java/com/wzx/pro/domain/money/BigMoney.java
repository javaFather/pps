package com.wzx.pro.domain.money;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name="big_money")
public class BigMoney implements Serializable {

    private Long id;

    private Date time;

    private String term;

    private String one;
    private String two;
    private String three;
    private String four;
    private String five;
    private String bigOne;
    private String bigTwo;
    private String str;
    private String last;
}
