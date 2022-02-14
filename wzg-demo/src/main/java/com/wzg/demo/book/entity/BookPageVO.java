package com.wzg.demo.book.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
@ApiModel(value = "BookPageVO对象", description = "BookPageVO对象")
public class BookPageVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标识主键")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("出版日期")
    private LocalDateTime pubTime;

    @ApiModelProperty("创建日期")
    private LocalDateTime createTime;

}
