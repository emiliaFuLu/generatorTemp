package com.mlatin.generator;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * MySQL 数据库代码生成类
 * @author Erwin Feng
 * @since 2019-04-17 10:33
 */
public class MySQL8CodeGenerator {

    public static void main(String[] args) {
        DbType dbType = DbType.MYSQL;
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        String driver = "com.mysql.cj.jdbc.Driver";
        // 表前缀，生成的实体类，不含前缀
        String[] tablePrefixes = {};
        // 表名，为空，生成所有的表
        String[] tableNames = {"spcc_goods"};
        // 字段前缀
        String[] fieldPrefixes = {};
        // 基础包名
        String packageName = null;
        CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes);
    }

}
