package com.wzx.pro.domain.customer;

import com.wzx.pro.domain.base.AbstractEntity;
import lombok.Data;

/**
 * 客户
 */
@Data
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
}
