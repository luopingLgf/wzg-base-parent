package com.wzg.demo.book.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wzg.demo.book.entity.*;
import com.wzg.demo.book.service.IBookService;
import com.wzg.framework.api.Result;
import com.wzg.framework.excel.ExcelUtils;
import com.wzg.framework.exception.CustomException;
import com.wzg.framework.page.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 书本表 前端控制器
 * </p>
 *
 * @author LuoPing
 * @since 2022-02-10
 */
@RestController
@RequestMapping("/book")
@Api(tags = "书本控制类")
public class BookController {
    private final IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @ApiOperationSupport(order = 1)
    @ApiOperation("书本-保存")
    @PostMapping("/save")
    public Result<Long> save(@RequestBody BookDTO bookDTO) {
        Long id = iBookService.saveDTO(bookDTO);
        return Result.success(id);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation("书本-批量保存")
    @PostMapping("/batchSave")
    public Result<Boolean> save(@RequestBody List<BookDTO> bookDTOS) {
        Boolean r = iBookService.batchSaveDTO(bookDTOS);
        return r ? Result.success() : Result.fail("保存失败");
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation("书本-分页列表")
    @PostMapping("/page")
    public Result<PageVO<BookPageVO>> page(@RequestBody BookPageDTO bookPageDTO) {
        PageVO<BookPageVO> bookPageVO = iBookService.pageVO(bookPageDTO);
        return Result.success(bookPageVO);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation("书本-查看详情")
    @GetMapping("/detail")
    public Result<BookVO> detail(@RequestParam Long id) {
        Book book = iBookService.getById(id);
        BookVO bookVO = BookMapping.INSTANCE.po2VO(book);
        return Result.success(bookVO);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("书本-修改")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody BookDTO bookDTO) {
        Boolean r = iBookService.updateDTO(bookDTO);
        return r ? Result.success() : Result.fail("修改失败");
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation("书本-批量删除")
    @PostMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            throw new CustomException("请选择需要删除的记录");
        }
        Boolean r = iBookService.removeBatchByIds(ids);
        return r ? Result.success() : Result.fail("删除失败");
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation("书本-批量修改")
    @PostMapping("/batchUpdate")
    public Result<Boolean> batchUpdate(@RequestBody List<BookDTO> bookDTOS) {
        Boolean r = iBookService.batchUpdateDTOS(bookDTOS);
        return r ? Result.success() : Result.fail("修改失败");
    }

    @ApiOperationSupport(order = 7)
    @ApiOperation("书本-导出")
    @PostMapping("/export")
    public void export(@RequestBody BookPageDTO bookPageDTO, HttpServletResponse response) throws IOException {
        List<BookExportVO> bookExportVOS = iBookService.listExport(bookPageDTO);
        ExcelUtils<BookExportVO> excelUtils = new ExcelUtils<>(BookExportVO.class);
        excelUtils.exportExcel(response, bookExportVOS, "书本");
    }

}
