package com.wzx.pro.test;

import com.wzx.pro.dao.reach.RobotReachRecordDetailMapper;
import com.wzx.pro.domain.reach.RobotReachRecordDetailEntity;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShardingJdbcTest {

    @Resource
    private RobotReachRecordDetailMapper robotReachRecordDetailMapper;

    @Test
    public void testInsert() {
        for (int i = 0; i < 10000; i++) {
            RobotReachRecordDetailEntity entity = new RobotReachRecordDetailEntity();
            entity.setFlowNo(System.currentTimeMillis() + "");
            entity.setPhoneNo(130 + i + "");
            entity.setIsDelete(0);
            entity.setCreatedBy("sys");
            entity.setUpdatedBy("sys");
            entity.setDateCreated(new Date());
            entity.setDateUpdated(new Date());
            entity.setId(Long.parseLong(i + ""));
            robotReachRecordDetailMapper.insert(entity);
        }
    }

    @Test
    public void getEntity() {
        RobotReachRecordDetailEntity entity = new RobotReachRecordDetailEntity();
        entity.setFlowNo("1701851108765");
        List<RobotReachRecordDetailEntity> byFlowNo = robotReachRecordDetailMapper.findByFlowNo(entity);
        log.info("{}", byFlowNo);
    }

    @Test
    public void getEntitys() {
        List<String> strings = Lists.newArrayList("1701851108408", "1701851108417","1701851108482");
        List<RobotReachRecordDetailEntity> byFlowNo = robotReachRecordDetailMapper.findByList(strings);
        log.info("{}", byFlowNo);
    }

}
