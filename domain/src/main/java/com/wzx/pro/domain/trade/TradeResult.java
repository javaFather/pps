package com.wzx.pro.domain.trade;

import com.wzx.pro.domain.base.AbstractEntity;
import lombok.Data;

/**
 * 交易结果
 */
@Data
public class TradeResult extends AbstractEntity {
    /**
     * 交易流水
     */
    private String flowNo;
    /**
     * 商品编码
     */
    private String productCode;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 交易价格
     */
    private String productPrice;
    /**
     * 客户ID
     */
    private String customerId;
    /**
     * 交易结果状态
     */
    private String status;
    /**
     * 付款方式
     */
    private String tradeType;
}
