package com.wzg.demo.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzg.demo.book.entity.*;
import com.wzg.demo.book.mapper.BookMapper;
import com.wzg.demo.book.service.IBookService;
import com.wzg.framework.constant.BaseConstant;
import com.wzg.framework.exception.CustomException;
import com.wzg.framework.mybatis.IdSnowUtils;
import com.wzg.framework.mybatis.QueryWrapperBuilder;
import com.wzg.framework.page.PageUtils;
import com.wzg.framework.page.PageVO;
import com.wzg.framework.util.CopyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 书本表 服务实现类
 * </p>
 *
 * @author LuoPing
 * @since 2022-02-10
 */
@Service
@Slf4j
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    /**
     * 保存单个书本对象
     *
     * @param bookDTO 书本dto对象
     * @return 书本对象ID
     */
    @Override
    public Long saveDTO(BookDTO bookDTO) {
        Book book = BookMapping.INSTANCE.dto2PO(bookDTO);
        book.setCreateId(10002L);
        book.setCreateTime(LocalDateTime.now());
        int r = baseMapper.insert(book);
        if (r != 1) {
            throw new CustomException("保存失败");
        }
        return book.getId();
    }

    /**
     * 批量保存书本列表
     *
     * @param bookDTOS
     * @return 保存结果
     */
    @Override
    public Boolean batchSaveDTO(List<BookDTO> bookDTOS) {
        List<Book> books = BookMapping.INSTANCE.dto2POList(bookDTOS);
        Book book = books.get(0);
        int size = 100000;
        List<Book> bookCopyList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Book clone = CopyUtils.serialClone(book);
            clone.setTitle(clone.getTitle() + i);
            clone.setAuthor(clone.getAuthor() + i);
            clone.setPrice(clone.getPrice().add(new BigDecimal(new Random().nextInt(100))));
            bookCopyList.add(clone);
        }

        long s = System.currentTimeMillis();

        Long accountId = 10001L;
        LocalDateTime nowTime = LocalDateTime.now();
        bookCopyList.stream().forEach(o -> {
            o.setId(IdSnowUtils.genId());
            o.setCreateId(accountId);
            o.setCreateTime(nowTime);
            o.setLogicDelete(0);
        });
        Integer column = baseMapper.insertBatchSomeColumn(bookCopyList);
        long e = System.currentTimeMillis();
        log.info("批量保存消耗时间：{} 毫秒！", e - s);

        return bookDTOS.size() == column;
    }

    /**
     * 分页查询
     *
     * @param bookPageDTO 查询对象
     * @return 分页列表
     */
    @Override
    public PageVO<BookPageVO> pageVO(BookPageDTO bookPageDTO) {
        QueryWrapper<Book> queryWrapper = QueryWrapperBuilder.build(bookPageDTO);
        IPage<Book> iPage = baseMapper.selectPage(new Page<>(bookPageDTO.getPageNum(), bookPageDTO.getPageSize()), queryWrapper);
        return PageUtils.toPageVO(iPage, BookMapping.INSTANCE::po2PageVOList);
    }

    /**
     * 修改书本对象
     *
     * @param bookDTO 书本dto对象
     * @return 更新结果
     */
    @Override
    public Boolean updateDTO(BookDTO bookDTO) {
        Book book = BookMapping.INSTANCE.dto2PO(bookDTO);
        book.setModifyId(10001L);
        book.setModifyTime(LocalDateTime.now());
        int update = baseMapper.updateById(book);
        return update == 1;
    }

    /**
     * 批量修改书本对象
     *
     * @param bookDTOS dto对象列表
     * @return 修改成功标志
     */
    @Override
    public Boolean batchUpdateDTOS(List<BookDTO> bookDTOS) {
        List<Book> books = BookMapping.INSTANCE.dto2POList(bookDTOS);
        Long accountId = 10001L;
        LocalDateTime nowTime = LocalDateTime.now();
        books.stream().forEach(o -> {
            o.setModifyId(accountId);
            o.setModifyTime(nowTime);
        });
        boolean b = this.updateBatchById(books, BaseConstant.BatchSize.BATCH_SIZE_50);
        return b;
    }

    /**
     * 导出书本列表
     * @param bookPageDTO 查询条件
     * @return 书本列表
     */
    @Override
    public List<BookExportVO> listExport(BookPageDTO bookPageDTO) {
        QueryWrapper<Book> queryWrapper = QueryWrapperBuilder.build(bookPageDTO);
        List<Book> books = baseMapper.selectList(queryWrapper);
        return BookMapping.INSTANCE.po2ExportVOList(books);
    }

}
