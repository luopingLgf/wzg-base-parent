package com.wzg.demo.constant;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description: BeanDefinition测试
 * @Author: LuoPing
 * @Date: 2022/2/8
 **/
@Component
@Lazy
@Scope
@DependsOn
@Primary
public class BeanDefinitionTest {

    @Bean
    public YamlParams getYamlParams() {
        return new YamlParams();
    }
}
