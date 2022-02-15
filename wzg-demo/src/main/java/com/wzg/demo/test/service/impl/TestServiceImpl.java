package com.wzg.demo.test.service.impl;

import com.wzg.demo.constant.ConfigParams;
import com.wzg.demo.test.entity.dto.PayDTO;
import com.wzg.demo.test.service.IPayTypeService;
import com.wzg.demo.test.service.ITestService;
import com.wzg.framework.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 测试服务类
 *
 * @author LuoPing
 * @since 2022/1/26
 */
@Service
@Slf4j
public class TestServiceImpl implements ITestService {
    private final ConfigParams yamlParams;
    private final IPayTypeService iPayTypeService;
    private final RedisService redisService;

    public TestServiceImpl(ConfigParams yamlParams, IPayTypeService iPayTypeService, RedisService redisService) {
        this.yamlParams = yamlParams;
        this.iPayTypeService = iPayTypeService;
        this.redisService = redisService;
    }

    @Override
    public void testYamlParams() {
        int test1 = yamlParams.getTest1();
        boolean test2 = yamlParams.isTest2();
        String test3 = yamlParams.getTest3();
        log.info("### test={},test2={}，test3={}", test1, test2, test3);

        redisService.set("demo:TestServiceImpl:testYamlParams", "测试redis", 180);
    }

    @Override
    public String getPayResult(PayDTO payDTO) {
        return iPayTypeService.payByType(payDTO);
    }
}
