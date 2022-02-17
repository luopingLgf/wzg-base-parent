package com.wzg.demo.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wzg.framework.mybatis.SearchType;
import com.wzg.framework.page.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 书本表
 * </p>
 *
 * @author LuoPing
 * @since 2022-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "BookPageDTO对象", description = "BookPageDTO对象")
public class BookPageDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标题")
    @SearchType(field = "title", type = SearchType.Type.LIKE)
    private String title;

    @SearchType(field = "author", type = SearchType.Type.RIGHT_LIKE)
    @ApiModelProperty("作者")
    private String author;

    @SearchType(field = "price", type = SearchType.Type.GT)
    @ApiModelProperty("价格")
    private BigDecimal price;

    @SearchType(field = "pub_time", type = SearchType.Type.LTE)
    @ApiModelProperty("出版日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8",locale = "zh")
    private LocalDateTime pubTime;

}
