package com.wzg.demo.constant;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description: @TODO
 * @Author: LuoPing
 * @Date: 2022/2/8
 **/
@Component
@Lazy
@Scope
@DependsOn
@Primary
public class BeanDefintionTest {

    @Bean
    public YamlParams getYamlParams() {
        return new YamlParams();
    }
}
