package com.wzx.pro.dao.reach;

import com.wzx.pro.domain.reach.RobotReachRecordDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RobotReachRecordDetailMapper {

    void insert(RobotReachRecordDetailEntity record);

    List<RobotReachRecordDetailEntity> findByFlowNo(RobotReachRecordDetailEntity record);

    List<RobotReachRecordDetailEntity> findByList(@Param("list") List<String> list);

}