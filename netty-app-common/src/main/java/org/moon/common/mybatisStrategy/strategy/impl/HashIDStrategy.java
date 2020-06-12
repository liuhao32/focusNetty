package org.moon.common.mybatisStrategy.strategy.impl;


import org.moon.common.mybatisStrategy.strategy.Strategy;
import org.moon.common.util.DateUtil;

/**
 * 按hash(ID)分表策略 目前分16张表
 *
 * @author ：YCKJ3275
 */
public class HashIDStrategy implements Strategy {

    @Override
    public String returnTableName(String tableName, String param) {
        final int tableNum = 16;
        int hash = DateUtil.get_hashID(param);
        int indexFor = hash & (tableNum - 1);
        return tableName + "_" + indexFor;
    }
}

