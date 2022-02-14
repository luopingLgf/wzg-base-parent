package com.wzg.demo.constant;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * BeanDefinition测试
 *
 * @author LuoPing
 * @since 2022/2/8
 */
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
