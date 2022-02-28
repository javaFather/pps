package com.wzx.pro.domain.trade;

import com.wzx.pro.domain.base.AbstractEntity;
import lombok.Data;

import javax.persistence.Table;

/**
 * 交易结果
 */
@Data
@Table(name="trade_result")
public class TradeResult extends AbstractEntity {
    /**
     * 交易流水
     */
    private String flowNo;
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 交易价格
     */
    private String productPrice;
    /**
     * 客户ID
     */
    private String customerId;
    /**
     * 交易结果状态 0000成功 1111处理中 2222 失败
     */
    private String status;
    /**
     * 付款方式 wechat 微信 alipay 支付宝
     */
    private String tradeType;

    public static void main(String[] args) {
        System.out.println(12%10);
    }
}
