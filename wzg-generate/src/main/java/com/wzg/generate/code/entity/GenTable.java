package com.wzg.generate.code.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 业务表 gen_table
 *
 * @author LuoPing
 * @since 2022-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "业务表 gen_table" , description = "业务表 gen_table")
public class GenTable {
    private static final long serialVersionUID = 1L;
    /**
     * 生成包路径
     */
    private String packageName;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表名称
     */
    private String commentName;

    /**
     * 表名称
     */
    private String datetime;

    /**
     * 表描述
     */
    private String tableComment;

    /**
     * 实体类名称(首字母大写)
     */
    private String className;

    /**
     * 实体类名称(首字母小写)
     */
    private String entityName;

    /**
     * 生成作者
     */
    private String author;

    /**
     * 主键信息
     */
    private GenTableColumn pkColumn;

    /**
     * 表列信息
     */
    private List<GenTableColumn> columns;

}
