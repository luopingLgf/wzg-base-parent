package com.wzg.framework.mybatis;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * mybatis-plus自定义ID生成器
 *
 * @author : LuoPing
 * @since : 2022/2/15
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        return IdSnowUtils.genId();
    }
}
