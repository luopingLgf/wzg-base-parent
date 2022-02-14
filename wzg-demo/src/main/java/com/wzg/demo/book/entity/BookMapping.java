package com.wzg.demo.book.entity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * MapStruct对象转化
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/11
 */
@Mapper
public interface BookMapping {
    BookMapping INSTANCE = Mappers.getMapper(BookMapping.class);

    /**
     * Book dto转po
     * @param bookDTO DTO对象
     * @return PO对象
     */
    Book toPO(BookDTO bookDTO);

    /**
     * Book dto转po
     * @param bookPageDTO DTO对象
     * @return PO对象
     */
    Book pageToPO(BookPageDTO bookPageDTO);

    /**
     * Book po转vo
     * @param book PO对象
     * @return VO对象
     */
    BookVO toVO(Book book);
}
