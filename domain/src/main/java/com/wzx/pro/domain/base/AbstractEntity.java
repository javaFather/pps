package com.wzx.pro.domain.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基类
 */
@Data
public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 5583035582769043365L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createdTime = new Date();

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 创建人
     */
    private String createdId ="wangzhenxing";

    /**
     * 修改人
     */
    private String modifierId;


}
