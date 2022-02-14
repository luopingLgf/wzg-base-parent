package com.wzg.demo.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzg.demo.book.entity.*;
import com.wzg.demo.book.mapper.BookMapper;
import com.wzg.demo.book.service.IBookService;
import com.wzg.framework.mybatis.QueryWrapperBuilder;
import com.wzg.framework.page.PageUtils;
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
    /**
     * 保存对象
     *
     * @param bookDTO dto对象
     * @return 对象ID
     */
    @Override
    public Long saveDTO(BookDTO bookDTO) {
        Book book = BookMapping.INSTANCE.dto2PO(bookDTO);
        book.setCreateTime(LocalDateTime.now());
        baseMapper.insert(book);
        return book.getId();
    }

    /**
     * 分页查询
     *
     * @param searchDTO 查询对象
     * @return 分页列表
     */
    @Override
    public PageVO<BookPageVO> pageVO(BookPageDTO searchDTO) {
        QueryWrapper<Book> queryWrapper = QueryWrapperBuilder.build(searchDTO);
        IPage<Book> iPage = baseMapper.selectPage(new Page<>(searchDTO.getPageNum(), searchDTO.getPageSize()), queryWrapper);
        return PageUtils.toPageVO(iPage, BookMapping.INSTANCE::po2PageVO);
    }

    /**
     * 修改对象
     *
     * @param bookDTO dto对象
     * @return 更新结果
     */
    @Override
    public Boolean updateDTO(BookDTO bookDTO) {
        Book book = BookMapping.INSTANCE.dto2PO(bookDTO);
        book.setCreateTime(LocalDateTime.now());
        int update = baseMapper.updateById(book);
        return update == 1;
    }
}
