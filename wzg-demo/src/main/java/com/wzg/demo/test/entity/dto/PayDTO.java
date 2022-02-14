package com.wzg.demo.test.entity.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 支付入参对象
 *
 * @author LuoPing
 * @since 2022/2/9
 */
@Data
@Builder
public class PayDTO {
    private String payType;
    private Long payId;
}
