package com.wzx.pro.domain.reach;

import com.wzx.pro.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RobotReachRecordDetailEntity extends BaseEntity {

    private static final long serialVersionUID = -8664218396817699487L;
    /**
     * 唯一识别ID幂等
     **/
    private String flowNo;

    /**
     * 手机号md5
     */

    private String phoneNo;


    /**
     * 是否删除 0: 否，1: 是
     **/
    private Integer isDelete;


}