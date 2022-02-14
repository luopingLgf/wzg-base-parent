package com.wzg.demo.test.service;

import com.wzg.demo.test.entity.dto.PayDTO;

/**
 * 支付方式服务接口
 *
 * @author LuoPing
 * @since 2022/2/9
 */
public interface IPayTypeService {
    /**
     * 根据支付方式进行支付
     *
     * @param payDTO 支付对象
     * @return 字符串
     */
    String payByType(PayDTO payDTO);

}
