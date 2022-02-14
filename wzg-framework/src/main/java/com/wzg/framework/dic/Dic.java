package com.wzg.framework.dic;

import java.lang.annotation.*;

/**
 * 字典注解
 *
 * @author : LuoPing
 * @since : 2022/2/10
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dic {
    /**
     * 来源，默认从system
     */
    String source() default "system";

    /**
     * 分组
     */
    String group();

    /**
     * 翻译来源字段名称，默认当前字段
     */
    String filed() default "";
}
