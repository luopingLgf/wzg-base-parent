package com.wzg.demo.test.controller;

import com.wzg.demo.test.entity.dto.PayDTO;
import com.wzg.demo.test.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制类
 *
 * @author : LuoPing
 * @date : 2022/1/26
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService iTestService;

    @GetMapping("/testYamlParams")
    public void testYamlParams() {
        iTestService.testYamlParams();
    }

    @GetMapping("/getPayResult")
    public String getPayResult(@RequestParam String payType) {
        PayDTO payDTO = PayDTO.builder().payType(payType).payId(1001L).build();
        return iTestService.getPayResult(payDTO);
    }
}
