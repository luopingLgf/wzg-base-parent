package com.wzg.framework.excel;

import java.lang.annotation.*;

/**
 * excel导出注解
 *
 * @author : LuoPing
 * @since : 2022/2/10
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Excel {
    String name() default "";
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";
    int sort() default 0;
}
