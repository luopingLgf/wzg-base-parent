package com.wzg.framework.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页入参对象
 *
 * @author LuoPing
 * @since 2022/2/9
 */
@Data
@ApiModel("分页人参对象")
public abstract class PageDTO {
    @ApiModelProperty("当前页码")
    private Integer pageSize;
    @ApiModelProperty("每页记录条数")
    private Integer pageNum;

}
