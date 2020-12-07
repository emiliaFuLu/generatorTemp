package com.mlatin.common.interceptor;

/**
 * @author: fl
 * @data: 2020-12-07 17:00
 * @description: 用于计数sql或者http的执行次数
 **/
public class RequestHolder {
    private final static ThreadLocal<Integer> SQL_HOLDER = ThreadLocal.withInitial(() -> 0);
    private final static ThreadLocal<Integer> HTTP_HOLDER = ThreadLocal.withInitial(() -> 0);

    public static void addSql() {
        SQL_HOLDER.set(getSql() + 1);
    }

    public static void addHttp() {
        HTTP_HOLDER.set(getHttp() + 1);
    }

    public static void removeSql() {
        SQL_HOLDER.remove();
    }

    public static Integer getSql() {
        return SQL_HOLDER.get();
    }

    public static Integer getHttp() {
        return HTTP_HOLDER.get();
    }

    public static void removeHttp() {
        HTTP_HOLDER.remove();
    }

}
