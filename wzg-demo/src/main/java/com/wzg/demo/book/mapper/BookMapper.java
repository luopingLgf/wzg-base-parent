package com.wzg.demo.book.mapper;

import com.wzg.demo.book.entity.Book;
import com.wzg.framework.mybatis.CustomMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 书本表 Mapper 接口
 * </p>
 *
 * @author LuoPing
 * @since 2022-02-10
 */
@Repository
public interface BookMapper extends CustomMapper<Book> {

}
