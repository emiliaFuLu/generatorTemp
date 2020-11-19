package com.mlatin.generator;

import com.baomidou.mybatisplus.annotation.DbType;

/**
* @Author: Lu Fu
* @Date: 2020/11/4 00:10
* @Description: MySQL 数据库代码生成类
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
        String[] tableNames = {};
        // 字段前缀
        String[] fieldPrefixes = {};
        // 基础包名
        String packageName = null;
        CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes);
    }

}
