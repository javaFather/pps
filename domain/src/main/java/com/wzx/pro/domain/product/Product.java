package com.wzx.pro.domain.product;

import com.wzx.pro.domain.base.AbstractEntity;
import lombok.Data;

import javax.persistence.Table;

/**
 * 商品
 */
@Data
@Table(name="product")
public class Product extends AbstractEntity {
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品编码
     */
    private String productCode;
    /**
     * 商品价格
     */
    private String productPrice;
    /**
     * 商品类型
     */
    private String productType;
}
