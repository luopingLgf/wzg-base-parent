package com.wzg.demo.test.service.impl;

import com.wzg.demo.test.entity.dto.PayDTO;
import com.wzg.demo.test.service.IPayTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 支付方式服务类
 *
 * @author LuoPing
 * @since 2022/2/9
 */
@Service
@Slf4j
public class PayTypeServiceImpl implements IPayTypeService {
    /**
     * 函数接口Map
     */
    private final Map<String, Function<PayDTO, String>> payTypeMap = new HashMap<>();

    /**
     * 初始化
     */
    @PostConstruct
    public void initFun() {
        payTypeMap.put("redPaper", this::redPaper);
        payTypeMap.put("shopping", this::shopping);
        payTypeMap.put("qqVip", this::qqVip);
    }

    /**
     * 根据类型进行支付
     *
     * @param payDTO xx
     * @return xx
     */
    @Override
    public String payByType(PayDTO payDTO) {
        Function<PayDTO, String> fun = payTypeMap.get(payDTO.getPayType());
        if (fun == null) {
            throw new RuntimeException("找不到该支付方式");
        }
        return fun.apply(payDTO);
    }

    /**
     * 支付方式： 红包
     *
     * @param payDTO xx
     * @return xx
     */
    private String redPaper(PayDTO payDTO) {
        log.info("payId == {}", payDTO.getPayId());
        return "payType == " + payDTO.getPayType();
    }

    /**
     * 支付方式： 购物卡
     *
     * @param payDTO xx
     * @return xx
     */
    private String shopping(PayDTO payDTO) {
        log.info("payId == {}", payDTO.getPayId());
        return "payType == " + payDTO.getPayType();
    }

    /**
     * 支付方式： QQ会员
     *
     * @param payDTO xx
     * @return xx
     */
    private String qqVip(PayDTO payDTO) {
        log.info("payId == {}", payDTO.getPayId());
        return "payType == " + payDTO.getPayType();
    }
}
