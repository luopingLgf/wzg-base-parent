package com.wzg.demo.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzg.demo.book.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.factory.Mappers;
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
public interface BookMapper extends BaseMapper<Book> {

}
