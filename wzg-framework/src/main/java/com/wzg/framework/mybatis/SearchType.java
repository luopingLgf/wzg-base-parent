package com.wzg.framework.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 查询条件注解
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SearchType {
    Type type() default Type.EQ;

    String field() default "";

    enum Type {
        EQ(0),
        NE(1),
        GT(2),
        GTE(3),
        LT(4),
        LTE(5),
        LIKE(6),
        IN(7),
        NOTIN(8),
        LEFT_LIKE(10),
        RIGHT_LIKE(11),
        ORDER_BY_COLUMN_DESC(12),
        ORDER_BY_COLUMN_ASC(13);

        public final int value;

        Type(int value){
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }
}
