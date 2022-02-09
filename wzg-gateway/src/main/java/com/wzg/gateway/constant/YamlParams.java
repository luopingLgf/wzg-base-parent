package com.wzg.gateway.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * yaml配置中心参数
 *
 * @author : LuoPing
 * @date : 2022/1/26
 */
@Component
@Data
@ConfigurationProperties(prefix = "params")
@RefreshScope
public class YamlParams {
    /**
     * 开启安全校验
     */
    private boolean enableSecure;
    /**
     * 校验参数
     */
    private boolean checkParam;
    /**
     * 校验XSS
     */
    private boolean checkXSS;
    /**
     * 校验SQL
     */
    private boolean checkSQL;
    /**
     * 校验CSRF
     */
    private boolean checkCSRF;
    /**
     * 校验IP黑名单
     */
    private boolean checkBlackIP;
}
