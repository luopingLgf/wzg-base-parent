package com.wzg.framework.util;

import com.wzg.framework.exception.CustomException;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>
 * 日期工具类
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/15
 */
public class MyDateUtils {
    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    public static final String parseDateToStr(final String format, Object date) {
        if (date instanceof Date) {
            return new SimpleDateFormat(format).format((Date) date);
        }
        if (date instanceof LocalDateTime) {
            return DateTimeFormatter.ofPattern(format).format((LocalDateTime) date);
        }
        throw new CustomException("时间类型错误");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return DateUtils.parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }
}
