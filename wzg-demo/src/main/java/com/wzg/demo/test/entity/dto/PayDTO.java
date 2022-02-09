package com.wzg.demo.test.entity.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @Description: @TODO
 * @Author: LuoPing
 * @Date: 2022/2/9
 **/
@Data
@Builder
public class PayDTO {
    private String payType;
    private Long payId;
}
