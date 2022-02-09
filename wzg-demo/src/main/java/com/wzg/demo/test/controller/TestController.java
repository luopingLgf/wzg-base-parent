package com.wzg.demo.test.controller;

import com.wzg.demo.test.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: @TODO
 * @Author: LuoPing
 * @Date: 2022/1/26
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService iTestService;

    @GetMapping("/testYamlParams")
    public void testYamlParams() {
        iTestService.testYamlParams();
    }
}
