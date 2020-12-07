package com.mlatin.common.interceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

/**
 * @author: fl
 * @data: 2020-12-07 17:09
 * @description: 通用变量统一拦截器
 **/
// todo 待完善
public class StatSqlInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
