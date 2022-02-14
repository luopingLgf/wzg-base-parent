package com.wzg.framework.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页出参对象
 *
 * @author : LuoPing
 * @since : 2022/2/10
 */
@Data
@ApiModel("分页出参对象")
public class PageVO<T> {
    @ApiModelProperty("当前页码")
    private Long pageNum;
    @ApiModelProperty("每页记录数")
    private Long pageSize;
    @ApiModelProperty("总数")
    private Long total;
    @ApiModelProperty("数据")
    private List<T> data;

    public PageVO() {
    }

    public PageVO(List<T> list) {
        long size = Integer.toUnsignedLong(list.size());
        this.pageNum = 1L;
        this.pageSize = size;
        this.total = size;
        this.data = list;
    }

}
