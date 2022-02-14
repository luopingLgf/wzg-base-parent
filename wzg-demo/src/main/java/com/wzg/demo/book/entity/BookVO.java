package com.wzg.demo.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value = "BookVO对象", description = "BookVO对象")
public class BookVO implements Serializable {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8",locale = "zh")
    private LocalDateTime pubTime;

    @ApiModelProperty("创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8",locale = "zh")
    private LocalDateTime createTime;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("逻辑删除 0未删除 1删除")
    private Integer logicDelete;

}
