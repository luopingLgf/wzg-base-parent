package com.wzg.demo.book.controller;


import com.wzg.demo.book.entity.*;
import com.wzg.demo.book.service.IBookService;
import com.wzg.framework.api.Result;
import com.wzg.framework.page.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
        BookVO bookVO = BookMapping.INSTANCE.toVO(book);
        return Result.success(bookVO);
    }

    @ApiOperation("书本-修改")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody BookDTO bookDTO) {
        Boolean r = iBookService.updateDTO(bookDTO);
        return Result.success(r);
    }
}
