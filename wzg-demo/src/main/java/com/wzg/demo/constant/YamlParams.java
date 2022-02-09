package com.wzg.demo.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Description: yaml配置中心参数
 * @Author: LuoPing
 * @Date: 2022/1/26
 **/
@Component
@Data
@ConfigurationProperties(prefix = "params")
@RefreshScope
public class YamlParams {
    /**
     * 测试数字
     */
    private int test1;
    /**
     * 测试布尔
     */
    private boolean test2;
    /**
     * 测试字符串
     */
    private String test3;
}
