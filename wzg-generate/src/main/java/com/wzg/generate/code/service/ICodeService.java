package com.wzg.generate.code.service;

import java.util.Map;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/17
 */
public interface ICodeService {
    /**
     * 预览生成的代码
     * @param tableId 表ID
     */
    Map<String, String> preview(Long tableId);
}
