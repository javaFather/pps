/*
 * Copyright (c) 2018 Wantu, All rights reserved.
 */
package com.wzx.pro.common.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description: 连接数据库信息
 */
@Configuration
@ComponentScan(basePackageClasses = DalModule.class)
@MapperScan(basePackages = "com.wzx.pro.dao")
public class DalModule {

    /**
     * SqlSessionFactory 实体
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setFailFast(true);
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*Mapper.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("ots_robot_reach_record_detail");
//        shardingRuleConfig.getBroadcastTables().add("t_config");
        // 根据流水号Hash分库 一共分为3个库
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(
                new InlineShardingStrategyConfiguration("flow_no", "db${Math.abs(flow_no.hashCode()) % 3}"));
        //TODO 根据ID分表  一共分为2张表
        //根据phone_no分表，一共分为3个表
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("phone_no", new PreciseModuloShardingTableAlgorithm()));
        Properties properties = new Properties();
        properties.setProperty("sql.show","true");
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, properties);
    }

    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
        return new KeyGeneratorConfiguration("SNOWFLAKE", "id");
    }

    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("ots_robot_reach_record_detail", "db${0..2}.ots_robot_reach_record_detail_${0..2}");
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return result;
    }


    Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("db0", DataSourceUtil.createDataSource("db0"));
        result.put("db1", DataSourceUtil.createDataSource("db1"));
        result.put("db2", DataSourceUtil.createDataSource("db2"));
        return result;
    }

}
