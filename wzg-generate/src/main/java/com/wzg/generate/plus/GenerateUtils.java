package com.wzg.generate.plus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * mybatis-plus代码自动生成工具类
 *
 * @author : LuoPing
 * @since : 2022/2/10
 */
public class GenerateUtils {

    public static void main(String[] args) {
        // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/wzg_base_demo?serverTimezone=GMT%2B8&useUnicode=true&useSSL=false&characterEncoding=utf8",
                        "wzg", "wzg@321")
                .globalConfig(builder -> {
                    builder.author("LuoPing") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                }).packageConfig(builder -> {
                    builder.parent("com.wzg") // 设置父包名
                            .moduleName("demo") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
                }).strategyConfig(builder -> {
                    builder.addInclude("t_book") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                }).templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
