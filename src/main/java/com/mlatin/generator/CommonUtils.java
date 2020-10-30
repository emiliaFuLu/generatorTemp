package com.mlatin.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.fengwenyi.code_generator.Config;
import com.mlatin.codegen.entity.BaseModel;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Erwin Feng
 * @since 2019-04-17 12:04
 */
public class CommonUtils {

    /**
     * 数据连接信息
     *
     * @param dbType   数据库类型
     * @param dbUrl    连接地址
     * @param username 用户名
     * @param password 密码
     * @param driver   驱动
     * @return DataSourceConfig
     */
    private static DataSourceConfig dataSourceConfig(DbType dbType, String dbUrl, String username, String password, String driver) {
        return new DataSourceConfig()
                .setDbType(dbType)
                .setUrl(dbUrl)
                .setUsername(username)
                .setPassword(password)
                .setDriverName(driver)
                ;
    }

    // 配置
    private static GlobalConfig globalConfig() {
        return new GlobalConfig()
                .setAuthor(com.fengwenyi.code_generator.Config.AUTHOR)
                .setOutputDir(Config.outputDir)
                .setFileOverride(true) // 是否覆盖已有文件
                .setOpen(true) // 是否打开输出目录
                .setDateType(DateType.TIME_PACK) // 时间采用java 8，（操作工具类：JavaLib => DateTimeUtils）
                .setActiveRecord(true)// 不需要ActiveRecord特性的请改为false
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(false)// XML ResultMap
                .setBaseColumnList(false)// XML columList
                .setKotlin(false) //是否生成 kotlin 代码
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
//                .setEntityName(Config.FILE_NAME_MODEL)
                .setMapperName(com.fengwenyi.code_generator.Config.FILE_NAME_DAO)
                .setXmlName(com.fengwenyi.code_generator.Config.FILE_NAME_XML)
                .setServiceName(com.fengwenyi.code_generator.Config.FILE_NAME_SERVICE)
                .setServiceImplName(com.fengwenyi.code_generator.Config.FILE_NAME_SERVICE_IMPL)
                .setControllerName(com.fengwenyi.code_generator.Config.FILE_NAME_CONTROLLER)
                .setIdType(IdType.INPUT) // 主键类型
                .setSwagger2(com.fengwenyi.code_generator.Config.SWAGGER_SUPPORT) // model swagger2
                ;
//                if (!serviceNameStartWithI)
//                    config.setServiceName("%sService");
    }

    private static StrategyConfig strategyConfig(String[] tablePrefixes, String[] tableNames, String[] fieldPrefixes) {
        TableFill createAt = new TableFill("createdAt", FieldFill.INSERT);
        TableFill updateAt = new TableFill("updatedAt", FieldFill.INSERT_UPDATE);
        return new StrategyConfig()
                .setCapitalMode(true) // 全局大写命名 ORACLE 注意
                .setSkipView(false) // 是否跳过视图
                .setTablePrefix(tablePrefixes)// 此处可以修改为您的表前缀(数组)
                .setFieldPrefix(fieldPrefixes) // 字段前缀
                .setNaming(NamingStrategy.underline_to_camel) // 表名生成策略
                .setInclude(tableNames)//修改替换成你需要的表名，多个表名传数组
                .setEntityLombokModel(true) // lombok实体
                .setChainModel(true) // 【实体】是否为构建者模型（默认 false）
                .setEntityColumnConstant(false) // 【实体】是否生成字段常量（默认 false）// 可通过常量名获取数据库字段名 // 3.x支持lambda表达式
                .setLogicDeleteFieldName(com.fengwenyi.code_generator.Config.ARCHIVE) // 逻辑删除属性名称
//                .setSuperEntityClass(BaseModel.class)
                .setSuperEntityColumns(new String[]{"id", "archive", "createAt", "updateAt"})
                .setTableFillList(Arrays.asList(createAt, updateAt))
                //.setDbColumnUnderline(true)
                //.setExclude(new String[]{"test"}) // 排除生成的表
                //.setEntityTableFieldAnnotationEnable
                //.entityTableFieldAnnotationEnable(true)
                ;
    }

    // 包信息配置
    private static PackageConfig packageConfig(String packageName) {
        return new PackageConfig()
                .setParent(packageName)
                .setController(com.fengwenyi.code_generator.Config.PACKAGE_NAME_CONTROLLER)
                .setEntity(com.fengwenyi.code_generator.Config.PACKAGE_NAME_MODEL)
                .setMapper(com.fengwenyi.code_generator.Config.PACKAGE_NAME_DAO)
                .setXml(com.fengwenyi.code_generator.Config.PACKAGE_NAME_XML)
                .setService(com.fengwenyi.code_generator.Config.PACKAGE_NAME_SERVICE)
                .setServiceImpl(com.fengwenyi.code_generator.Config.PACKAGE_NAME_SERVICE_IMPL)
                ;
    }

    /**
     * @param packageConfig
     * @return
     */
    private static InjectionConfig injectionConfig(final PackageConfig packageConfig) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> fileOutConfigList = new ArrayList<FileOutConfig>();
        fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                if (StringUtils.isEmpty(packageConfig.getModuleName())) {
                    return com.fengwenyi.code_generator.Config.projectPath + "/src/main/resources/mapper/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                } else {
                    return com.fengwenyi.code_generator.Config.projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName() + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                }
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        return injectionConfig;
    }

    /**
     * 获取模板引擎
     *
     * @return 模板引擎 {@link AbstractTemplateEngine}
     */
    private static AbstractTemplateEngine getTemplateEngine() {
        String templateEngine = com.fengwenyi.code_generator.Config.TEMPLATE_ENGINE;
        switch (templateEngine) {
            case "velocity":
                return new VelocityTemplateEngine();
            case "freemarker":
                return new FreemarkerTemplateEngine();
            case "beetl":
                return new BeetlTemplateEngine();
        }
        return new VelocityTemplateEngine();
    }

    /**
     * 执行器
     *
     * @param dbType
     * @param dbUrl
     * @param username
     * @param password
     * @param driver
     * @param tablePrefixes
     * @param tableNames
     * @param packageName
     */
    public static void execute(DbType dbType, String dbUrl, String username, String password, String driver,
                               String[] tablePrefixes, String[] tableNames, String packageName, String[] fieldPrefixes) {
        GlobalConfig globalConfig = globalConfig();
        DataSourceConfig dataSourceConfig = dataSourceConfig(dbType, dbUrl, username, password, driver);
        StrategyConfig strategyConfig = strategyConfig(tablePrefixes, tableNames, fieldPrefixes);
        PackageConfig packageConfig = packageConfig(packageName);
//        InjectionConfig injectionConfig = injectionConfig(packageConfig);
        AbstractTemplateEngine templateEngine = getTemplateEngine();
        new AutoGenerator()
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(templateEngine)
                //.setCfg(injectionConfig)
                .execute();
    }

}
