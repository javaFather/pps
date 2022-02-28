package com.wzx.pro.dao;

import com.wzx.pro.domain.money.BigMoney;
import tk.mybatis.mapper.common.Mapper;


public interface BigMoneyMapper extends Mapper<BigMoney> {

    BigMoney findBigMoney(BigMoney one);
}
