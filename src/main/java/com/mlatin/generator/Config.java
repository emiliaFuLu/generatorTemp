package com.mlatin.generator;

/**
* @Author: Lu Fu
* @Date: 2020/11/4 01:51
* @Description:
*/
public class Config {

    public static String JAVA_PATH = "src.main.java.com.mlatin";

    public static String RESOURCES_PATH = "src.main.resources";
    /** 包名：controller */
    public static final String PACKAGE_NAME_CONTROLLER = JAVA_PATH+".controller";

    /** 包名：service */
    public static final String PACKAGE_NAME_SERVICE = JAVA_PATH+".service";

    /** 包名：service.impl */
    public static final String PACKAGE_NAME_SERVICE_IMPL = JAVA_PATH+".service.impl";

    /** 包名：model */
    public static final String PACKAGE_NAME_MODEL = JAVA_PATH+".codegen.entity";

    /** 包名：dao */
    public static final String PACKAGE_NAME_DAO = JAVA_PATH+".codegen.dao";

    /** 包名：xml */
    public static final String PACKAGE_NAME_XML = RESOURCES_PATH+".mapper";

    /** 文件名后缀：Model */
    public static final String FILE_NAME_MODEL = "%sEntity";

    /** 文件名后缀：Dao */
    public static final String FILE_NAME_DAO = "%sDao";

    /** 文件名后缀：Mapper */
    public static final String FILE_NAME_XML = "%sMapper";

    /** MP开头，Service结尾 */
    public static final String FILE_NAME_SERVICE = "%sService";

    /** 文件名后缀：ServiceImpl */
    public static final String FILE_NAME_SERVICE_IMPL = "%sServiceImpl";

    /** 文件名后缀：Controller */
    public static final String FILE_NAME_CONTROLLER = "%sController";

    /** 逻辑删除字段 */
    public static final String ARCHIVE = "archive";

    /** 作者 */
    public static final String AUTHOR = "Lu Fu";

    /** 生成文件的输出目录 */
    public static String projectPath = System.getProperty("user.dir");

    /** 输出目录 */
//    public static final String outputDir = projectPath + "/src/main/java/";
//    public static final String outputDir = "/Users/fulu/ZeroToOne/generatorTemp";

    /** 模板引擎。velocity / freemarker / beetl */
    public static final String TEMPLATE_ENGINE = "velocity";

    /** 是否支持Swagger，默认不支持 */
    public static final Boolean SWAGGER_SUPPORT = false;


}
