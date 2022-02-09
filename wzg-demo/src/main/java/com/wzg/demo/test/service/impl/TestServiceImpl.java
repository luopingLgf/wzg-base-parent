package com.wzg.demo.test.service.impl;

import com.wzg.demo.constant.YamlParams;
import com.wzg.demo.test.entity.dto.PayDTO;
import com.wzg.demo.test.service.IPayTypeService;
import com.wzg.demo.test.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试服务类
 *
 * @author : LuoPing
 * @date : 2022/1/26
 */
@Service
@Slf4j
public class TestServiceImpl implements ITestService {
    @Autowired
    private YamlParams yamlParams;
    @Autowired
    private IPayTypeService iPayTypeService;

    @Override
    public void testYamlParams() {
        int test1 = yamlParams.getTest1();
        boolean test2 = yamlParams.isTest2();
        String test3 = yamlParams.getTest3();
        log.info("### test={},test2={}，test3={}", test1, test2, test3);
    }

    @Override
    public String getPayResult(PayDTO payDTO) {
        return iPayTypeService.payByType(payDTO);
    }
}
