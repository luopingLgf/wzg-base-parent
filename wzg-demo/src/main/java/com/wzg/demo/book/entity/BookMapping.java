package com.wzg.demo.book.entity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
     *
     * @param bookDTO BookDTO对象
     * @return Book对象
     */
    Book dto2PO(BookDTO bookDTO);

    /**
     * Book dto列表转po
     *
     * @param bookDTOS BookDTO对象列表
     * @return Book对象列表
     */
    List<Book> dto2POList(List<BookDTO> bookDTOS);

    /**
     * Book po转vo
     *
     * @param book Book对象
     * @return BookVO对象
     */
    BookVO po2VO(Book book);

    /**
     * Book po转pageVO列表
     *
     * @param books 书本对象
     * @return List<BookPageVO>
     */
    List<BookPageVO> po2PageVOList(List<Book> books);

    /**
     * Book po转exportVO列表
     *
     * @param books 书本对象
     * @return List<BookExportVO>
     */
    List<BookExportVO> po2ExportVOList(List<Book> books);
}
