import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * @Author WeiJin
 * @Version 1.0
 * @Date 2024/6/30 20:52
 */
public class test {
    static String packageName = "com.weijin.recruitment"; // 当前包名
    static String author = "WeiJin"; // 作者
    static String sqlUrl = "mysql://localhost:3306/"; // 数据库类型及地址
    static String sqlDb = "db_recruitment"; // 数据库名
    static String sqlUser = "root";
    static String sqlPassword = "w20040410";
//    String[] arr = new String[]{"t_user","t_station","t_resume_delivery","t_project","t_practice","t_position","t_interview","t_education","t_company","t_basic-information"};
    static String table = String.join(",", new String[]{"t_user","t_station","t_resume_delivery","t_project","t_practice","t_position","t_interview","t_education","t_company","t_basic-information"}); // 表，用逗号隔开

    public static void main(String[] args) {
        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir(System.getProperty("D:\\develop\\idea_workspace\\school-projects\\online-recruitment-system\\src\\main\\java") );
//        gc.setAuthor(author);
//        gc.setOpen(false);
//        gc.setServiceName("%sService");
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:" + sqlUrl + sqlDb + "?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername(sqlUser);
//        dsc.setPassword(sqlPassword);
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent(packageName);
//        pc.setEntity("model");
//        mpg.setPackageInfo(pc);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null); // 不生成MapperXML
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setRestControllerStyle(true);
//        strategy.setEntityTableFieldAnnotationEnable(true);
//
//        strategy.setInclude(table.split(","));
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix("t_"); // 表前缀，如t_user，没有就注释掉此行
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();



        FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_recruitment", "root", "w20040410")
                .globalConfig(builder -> {
                    builder.author("WeiJin") // 设置作者
                           // 开启 swagger 模式
                            .outputDir("D:\\develop\\idea_workspace\\school-projects\\online-recruitment-system\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.weijin.recruitment") // 设置父包名
//                                .moduleName("system") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\develop\\idea_workspace\\school-projects\\online-recruitment-system\\src\\main\\resources\\mapper")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude(table) // 设置需要生成的表名
                                .addTablePrefix("t_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
