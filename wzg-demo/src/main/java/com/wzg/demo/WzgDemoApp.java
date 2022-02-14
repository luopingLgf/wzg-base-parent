package com.wzg.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 入口类
 *
 * @author LuoPing
 * @since 2022/1/26
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wzg"})
public class WzgDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(WzgDemoApp.class, args);
    }

}
