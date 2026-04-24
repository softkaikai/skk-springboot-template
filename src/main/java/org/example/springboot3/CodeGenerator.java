package org.example.springboot1;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.model.ClassAnnotationAttributes;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        // 数据库连接信息（请替换为实际信息）
        String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&remarks=true&useInformationSchema=true";
        String username = "root";
        String password = "root";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> builder
                        .author("kaikai")                  // 1. 设置作者
                        .outputDir(System.getProperty("user.dir") + "/src/main/java")
                        .disableOpenDir()                     // 2. 生成后不自动打开目录
                        .enableSpringdoc()                    // 3. 启用SpringDoc (Swagger3)
                        .commentDate("yyyy-MM-dd")            // 4. 注释日期格式
                )
                .packageConfig(builder -> builder
                                .parent("org.example.springboot3")      // 5. 父包名
//                        .moduleName("biz")                    // 6. 模块名（可选）
                                .entity("entity")                     // 7. 实体类包名
                                .service("service")                   // 8. Service包名
                                .serviceImpl("service.impl")          // 9. ServiceImpl包名
                                .mapper("mapper")                     // 10. Mapper包名
                                .controller("controller")             // 11. Controller包名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"))
                )
                .strategyConfig(builder -> builder
                                .addInclude("product")           // 12. 要生成的表名
                                .addTablePrefix("t_", "c_", "sys_")   // 13. 过滤表前缀
                                .enableCapitalMode()                  // 14. 开启大写命名（如：USER -> User）

                                // 实体策略配置
                                .entityBuilder()
                                .naming(NamingStrategy.underline_to_camel)      // 15. 表名转驼峰
                                .columnNaming(NamingStrategy.underline_to_camel) // 16. 字段名转驼峰
                                .enableLombok(new ClassAnnotationAttributes("@Data", "lombok.Data")) // 17. 使用@Data注解
                                .enableTableFieldAnnotation()                   // 18. 生成@TableField注解
//                        .formatFileName("%sEntity")                     // 19. 实体类命名格式
                                .enableFileOverride()
                                .build()

                                // Mapper策略配置
                                .mapperBuilder()
                                .enableBaseResultMap()          // 20. 生成BaseResultMap
                                .enableBaseColumnList()         // 21. 生成BaseColumnList
                                .formatMapperFileName("%sMapper")
                                .formatXmlFileName("%sMapper")
                                .enableFileOverride()
                                .build()

                                // Service策略配置
                                .serviceBuilder()
                                .formatServiceFileName("%sService")           // 22. Service接口命名（无I前缀）
                                .formatServiceImplFileName("%sServiceImpl")   // 23. ServiceImpl命名
                                .build()

                                // Controller策略配置
                                .controllerBuilder()
                                .enableRestStyle()          // 24. 生成@RestController
                                .enableHyphenStyle()        // 25. URL驼峰转连字符（如：getUserById -> /get-user-by-id）
                                .formatFileName("%sController")
                                .build()
                )
                // 使用Freemarker模板引擎
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}