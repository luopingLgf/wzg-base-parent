package com.wzg.demo.book.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.wzg.demo.book.entity.*;
import com.wzg.demo.book.service.IBookService;
import com.wzg.framework.api.Result;
import com.wzg.framework.exception.CustomException;
import com.wzg.framework.page.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("书本-保存")
    @PostMapping("/save")
    public Result<Long> save(@RequestBody BookDTO bookDTO) {
        Long id = iBookService.saveDTO(bookDTO);
        return Result.success(id);
    }

    @ApiOperation("书本-保存-批量")
    @PostMapping("/batchSave")
    public Result<Boolean> save(@RequestBody List<BookDTO> bookDTOS) {
        Boolean r = iBookService.batchSaveDTO(bookDTOS);
        return r ? Result.success() : Result.fail("保存失败");
    }

    @ApiOperation("书本-分页列表")
    @PostMapping("/page")
    public Result<PageVO<BookPageVO>> page(@RequestBody BookPageDTO bookPageDTO) {
        PageVO<BookPageVO> bookPageVO = iBookService.pageVO(bookPageDTO);
        return Result.success(bookPageVO);
    }

    @ApiOperation("书本-查看详情")
    @GetMapping("/detail")
    public Result<BookVO> detail(@RequestParam Long id) {
        Book book = iBookService.getById(id);
        BookVO bookVO = BookMapping.INSTANCE.po2VO(book);
        return Result.success(bookVO);
    }

    @ApiOperation("书本-修改")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody BookDTO bookDTO) {
        Boolean r = iBookService.updateDTO(bookDTO);
        return r ? Result.success() : Result.fail("修改失败");
    }

    @ApiOperation("书本-删除-批量")
    @PostMapping("/batchDelete")
    public Result<Boolean> batchDelete(@RequestBody List<Long> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            throw new CustomException("请选择需要删除的记录");
        }
        Boolean r = iBookService.removeBatchByIds(ids);
        return r ? Result.success() : Result.fail("删除失败");
    }

    @ApiOperation("书本-修改-批量")
    @PostMapping("/batchUpdate")
    public Result<Boolean> batchUpdate(@RequestBody List<BookDTO> bookDTOS) {
        Boolean r = iBookService.batchUpdateDTOS(bookDTOS);
        return r ? Result.success() : Result.fail("修改失败");
    }

    @ApiOperation("书本-导出")
    @PostMapping("/export")
    public Result<Boolean> export(@RequestBody List<BookDTO> bookDTOS) {
        Boolean r = iBookService.batchUpdateDTOS(bookDTOS);
        return r ? Result.success() : Result.fail("修改失败");
    }
}
