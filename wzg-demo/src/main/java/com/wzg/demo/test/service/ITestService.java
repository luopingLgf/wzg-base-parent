package com.wzg.demo.test.service;

import com.wzg.demo.test.entity.dto.PayDTO;

/**
 * 测试服务接口
 *
 * @author : LuoPing
 * @date : 2022/1/26
 */
public interface ITestService {
    /**
     * 测试yaml参数
     */
    void testYamlParams();

    /**
     * Map + 函数式接口 获取不同的支付结果
     *
     * @param payType
     * @return
     */
    String getPayResult(PayDTO payDTO);
}
