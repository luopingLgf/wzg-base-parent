package com.wzg.demo.book.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_book")
@ApiModel(value = "Book对象", description = "书本表")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标识主键")
    @TableId("id")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("出版日期")
    private LocalDateTime pubTime;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("逻辑删除 0未删除 1删除")
    @TableLogic
    private Integer logicDelete;

    @ApiModelProperty("创建人ID")
    private Long createId;

    @ApiModelProperty("创建日期")
    private LocalDateTime createTime;

    @ApiModelProperty("修改人ID")
    private Long modifyId;

    @ApiModelProperty("修改日期")
    private LocalDateTime modifyTime;
}
