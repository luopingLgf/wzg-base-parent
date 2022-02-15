package com.wzg.demo.book.entity;

import com.wzg.framework.excel.Excel;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 书本导出对象
 * </p>
 *
 * @author LuoPing
 * @since 2022-02-10
 */
@Data
@ApiModel(value = "书本导出对象", description = "书本导出对象")
public class BookExportVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Excel(name = "标题", sort = 1)
    private String title;

    @Excel(name = "作者", sort = 2)
    private String author;

    @Excel(name = "价格", cellType = Excel.ColumnType.NUMERIC, sort = 3)
    private BigDecimal price;

    @Excel(name = "描述", sort = 4)
    private String description;

    @Excel(name = "出版日期", dateFormat = "yyyy-MM-dd HH:mm:ss", sort = 5)
    private LocalDateTime pubTime;

}
