package com.wzx.pro.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity extends BaseDomain{
    private static final long serialVersionUID = 7952514626314547466L;

    private Long id;

    private Date dateCreated;

    private String createdBy;

    private Date dateUpdated;

    private String updatedBy;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
