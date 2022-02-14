package com.wzg.demo.test.controller;

import com.wzg.demo.test.entity.dto.PayDTO;
import com.wzg.demo.test.service.ITestService;
import com.wzg.framework.api.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制类
 *
 * @author LuoPing
 * @since 2022/1/26
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试demo")
public class TestController {
    private final ITestService iTestService;

    public TestController(ITestService iTestService) {
        this.iTestService = iTestService;
    }

    @ApiOperation("测试获取yaml参数")
    @GetMapping("/testYamlParams")
    public Result<Void> testYamlParams() {
        iTestService.testYamlParams();
        return Result.success();
    }

    @ApiOperation("测试函数接口Map")
    @GetMapping("/getPayResult")
    public Result<String> getPayResult(@RequestParam String payType) {
        PayDTO payDTO = PayDTO.builder().payType(payType).payId(1001L).build();
        String payResult = iTestService.getPayResult(payDTO);
        return Result.success(payResult);
    }
    
}
