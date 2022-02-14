package com.wzg.framework.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzg.framework.exception.CustomException;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * <p>
 * QueryWrapper构建工具类
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/11
 */
public class QueryWrapperBuilder {
    /**
     * 构建 QueryWrapper
     */
    public static <T> QueryWrapper<T> build(Object obj) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            SearchType annotation = field.getAnnotation(SearchType.class);
            field.setAccessible(true);
            if (annotation == null || StringUtils.isBlank(annotation.field())) {
                continue;
            }
            SearchType.Type type = annotation.type();
            if (type.equals(SearchType.Type.ORDER_BY_COLUMN_DESC)) {
                queryWrapper.orderByDesc(annotation.field());
            } else if (type.equals(SearchType.Type.ORDER_BY_COLUMN_ASC)) {
                queryWrapper.orderByAsc(annotation.field());
            }

            Object object;
            try {
                object = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new CustomException("搜索条件反射构建异常");
            }
            if (object == null || StringUtils.isEmpty(object.toString())) {
                continue;
            }

            if (type.equals(SearchType.Type.EQ)) {
                queryWrapper.eq(annotation.field(), object);
            } else if (type.equals(SearchType.Type.NE)) {
                queryWrapper.ne(annotation.field(), object);
            } else if (type.equals(SearchType.Type.LIKE)) {
                queryWrapper.like(annotation.field(), object);
            } else if (type.equals(SearchType.Type.GT)) {
                queryWrapper.gt(annotation.field(), object);
            } else if (type.equals(SearchType.Type.LT)) {
                queryWrapper.lt(annotation.field(), object);
            } else if (type.equals(SearchType.Type.GTE)) {
                queryWrapper.ge(annotation.field(), object);
            } else if (type.equals(SearchType.Type.LTE)) {
                queryWrapper.le(annotation.field(), object);
            } else if (type.equals(SearchType.Type.LEFT_LIKE)) {
                queryWrapper.likeLeft(annotation.field(), object);
            } else if (type.equals(SearchType.Type.RIGHT_LIKE)) {
                queryWrapper.likeRight(annotation.field(), object);
            }
        }
        return queryWrapper;
    }
}
