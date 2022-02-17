package com.wzg.generate.code.service.impl;

import com.fasterxml.jackson.core.JsonEncoding;
import com.wzg.generate.code.entity.GenTable;
import com.wzg.generate.code.entity.GenTableColumn;
import com.wzg.generate.code.service.ICodeService;
import com.wzg.generate.util.VelocityUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/17
 */
@Service
public class CodeServiceImpl implements ICodeService {

    /**
     * 预览生成的代码
     *
     * @param tableId 表ID
     */
    @Override
    public Map<String, String> preview(Long tableId) {
        // 获取用户参数
        String author = "LuoPing";
        // 获取库设置
        String basePackage = "com.wzg.demo";
        // 获取表设置
        String tableName = "t_dic";
        // 获取表字段设置
        GenTableColumn genTableColumn = new GenTableColumn().setColumnName("id").setJavaType("Long").setJavaField("id").setColumnComment("主键ID");
        GenTableColumn genTableColumn1 = new GenTableColumn().setColumnName("user_name").setJavaType("String").setJavaField("userName").setColumnComment("用户名");
        GenTableColumn genTableColumn2 = new GenTableColumn().setColumnName("age").setJavaType("Integer").setJavaField("age").setColumnComment("年龄");
        GenTableColumn genTableColumn3 = new GenTableColumn().setColumnName("create_time").setJavaType("LocalDateTime").setJavaField("createTime").setColumnComment("创建时间");
        List<GenTableColumn> tableColumns = Arrays.asList(genTableColumn, genTableColumn1, genTableColumn2, genTableColumn3);
        // 获取模板
        GenTable genTable = new GenTable().setAuthor(author).setClassName("User").setEntityName("user").setPackageName(basePackage)
                .setTableName("t_user").setColumns(tableColumns);
        VelocityContext velocityContext = VelocityUtils.prepareContext(genTable);
        // 获取模板
        List<String> genTemplates = VelocityUtils.getGenTemplateList();

        Map<String, String> dataMap = new HashMap<>();
        for (String genTemplate : genTemplates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template template = Velocity.getTemplate(genTemplate, JsonEncoding.UTF8.getJavaName());
            template.merge(velocityContext, sw);
            dataMap.put(genTemplate, sw.toString());
        }
        return dataMap;
    }
}
