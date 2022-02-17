package com.wzg.generate.util;

import com.wzg.generate.code.entity.GenTable;
import org.apache.velocity.VelocityContext;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author LuoPing
 * @since 2022/2/17
 */
public class VelocityUtils {

    public static VelocityContext prepareContext(GenTable genTable) {
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("tableName", genTable.getTableName());
        velocityContext.put("functionName", genTable.getCommentName());
        velocityContext.put("className", genTable.getClassName());
        velocityContext.put("entityName", genTable.getEntityName());
        velocityContext.put("packageName", genTable.getPackageName());
        velocityContext.put("author", genTable.getAuthor());
        velocityContext.put("datetime", genTable.getDatetime());
        velocityContext.put("columns", genTable.getColumns());
        return velocityContext;
    }

    public static List<String> getGenTemplateList() {
        List<String> templates = new ArrayList<>();
        templates.add("vm/java/Controller.java.vm");
        templates.add("vm/java/Dto.java.vm");
        templates.add("vm/java/Entity.java.vm");
        templates.add("vm/java/EntityMapping.java.vm");
        templates.add("vm/java/ExportVo.java.vm");
        templates.add("vm/java/IService.java.vm");
        templates.add("vm/java/Mapper.java.vm");
        templates.add("vm/java/Mapper.xml.vm");
        templates.add("vm/java/PageDto.java.vm");
        templates.add("vm/java/PageVo.java.vm");
        templates.add("vm/java/ServiceImpl.java.vm");
        templates.add("vm/java/Vo.java.vm");
        return templates;
    }
}
