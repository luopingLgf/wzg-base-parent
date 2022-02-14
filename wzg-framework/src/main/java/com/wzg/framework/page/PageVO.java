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
    private Integer pageNum;
    @ApiModelProperty("每页记录数")
    private Integer pageSize;
    @ApiModelProperty("总数")
    private Integer total;
    @ApiModelProperty("数据")
    private List<T> data;

    public PageVO() {
    }

    public PageVO(List<T> list) {
        this.data = list;
        this.total = list.size();
    }

}
