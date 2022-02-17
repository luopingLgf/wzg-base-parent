package com.wzg.generate.code.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wzg.framework.api.Result;
import com.wzg.generate.code.service.ICodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 代码生成-API接口类
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/17
 */
@RestController
@RequestMapping("/code")
@Api(tags = "代码生成-API接口类")
public class CodeGenerateController {
    private final ICodeService iCodeService;

    public CodeGenerateController(ICodeService iCodeService) {
        this.iCodeService = iCodeService;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("代码生成-预览")
    @GetMapping("/preview")
    public Result<Long> preview(@RequestParam Long tableId) {
        iCodeService.preview(tableId);
        return Result.success();
    }
}
