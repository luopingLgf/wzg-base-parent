package com.wzg.demo.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzg.demo.book.entity.*;
import com.wzg.demo.book.mapper.BookMapper;
import com.wzg.demo.book.service.IBookService;
import com.wzg.framework.mybatis.QueryWrapperBuilder;
import com.wzg.framework.page.PageVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 书本表 服务实现类
 * </p>
 *
 * @author LuoPing
 * @since 2022-02-10
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Override
    public Long saveDTO(BookDTO bookDTO) {
        Book book = BookMapping.INSTANCE.toPO(bookDTO);
        book.setCreateTime(LocalDateTime.now());
        baseMapper.insert(book);
        return book.getId();
    }

    @Override
    public PageVO<BookPageVO> pageVO(BookPageDTO bookPageDTO) {
        QueryWrapper<Book> queryWrapper = QueryWrapperBuilder.build(bookPageDTO);
        IPage<Book> page = new Page<>(bookPageDTO.getPageNum(), bookPageDTO.getPageSize());
        IPage record = baseMapper.selectPage(page, queryWrapper);
        return null;
    }

    @Override
    public Boolean updateDTO(BookDTO bookDTO) {
        Book book = BookMapping.INSTANCE.toPO(bookDTO);
        book.setCreateTime(LocalDateTime.now());
        baseMapper.updateById(book);
        return null;
    }
}
