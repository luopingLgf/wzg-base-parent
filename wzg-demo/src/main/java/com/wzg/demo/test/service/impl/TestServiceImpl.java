package com.wzg.demo.test.service.impl;

import com.wzg.demo.constant.YamlParams;
import com.wzg.demo.test.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: @TODO
 * @Author: LuoPing
 * @Date: 2022/1/26
 **/
@Service
@Slf4j
public class TestServiceImpl implements ITestService {
    private final YamlParams yamlParams;

    public TestServiceImpl(YamlParams yamlParams) {
        this.yamlParams = yamlParams;
    }

    @Override
    public void testYamlParams() {
        int test1 = yamlParams.getTest1();
        boolean test2 = yamlParams.isTest2();
        String test3 = yamlParams.getTest3();
        log.info("### test={},test2={}，test3={}", test1, test2, test3);
    }
}
