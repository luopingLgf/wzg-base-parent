package com.wzg.framework.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * mybatis-plus自定义mapper基类
 *
 * @author : LuoPing
 * @since : 2022/2/15
 */
public interface CustomMapper<T> extends BaseMapper<T> {
    /**
     * 真正的批量插入
     *
     * @param entityList 实体列表
     * @return 影响行数
     */
    Integer insertBatchSomeColumn(Collection<T> entityList);
}