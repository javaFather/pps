package com.wzx.pro.domain.customer;

import com.wzx.pro.domain.base.AbstractEntity;
import lombok.Data;

import javax.persistence.Table;

/**
 * 客户
 */
@Data
@Table(name="customer")
public class Customer extends AbstractEntity {
    /**
     * 客户ID
     */
    private String customerId;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 身份证号
     */
    private String idNo;

    public Customer(){}
    public Customer (Customer customer){
        this.customerId= customer.getCustomerId() ;
    }
}
