package com.wzg.demo.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzg.demo.book.entity.Book;
import com.wzg.demo.book.entity.BookDTO;
import com.wzg.demo.book.entity.BookPageDTO;
import com.wzg.demo.book.entity.BookPageVO;
import com.wzg.framework.page.PageVO;

/**
 * <p>
 * 书本表 服务类
 * </p>
 *
 * @author LuoPing
 * @since 2022-02-10
 */
public interface IBookService extends IService<Book> {
    /**
     * 保存书本对象
     * @param bookDTO dto对象
     * @return 书本主键
     */
    Long saveDTO(BookDTO bookDTO);

    /**
     * 分页查询书本
     * @param bookPageDTO 查询对象
     * @return 分页列表
     */
    PageVO<BookPageVO> pageVO(BookPageDTO bookPageDTO);

    /**
     * 修改书本对象
     * @param bookDTO dto对象
     * @return 修改成功标志
     */
    Boolean updateDTO(BookDTO bookDTO);
}