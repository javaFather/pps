package com.wzx.pro.common.config;


import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Description: 表分片规则
 */
public final class PreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<String> shardingValue) {
        for (String each : tableNames) {
            if (each.endsWith(Integer.parseInt(shardingValue.getValue()) % 3 + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}