package com.mlatin.common.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: yuyong
 * @date: 2018-11-12 11:41 AM
 * desc:
 */
public class IdUtil {

    public static void main(String[] args) {
        new Thread(() -> {
            Set<Long> ids = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                Long id = getGuid();
                ids.add(id);
            }
            System.out.println(ids.size());
        }).start();
        new Thread(() -> {
            Set<Long> ids = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                Long id = getGuid();
                ids.add(id);
            }
            System.out.println(ids.size());
        }).start();
        new Thread(() -> {
            Set<Long> ids = new HashSet<>();
            for (int i = 0; i < 10000; i++) {
                Long id = getGuid();
                ids.add(id);
            }
            System.out.println(ids.size());
        }).start();

    }

    /**
     * 16位末尾的数字id
     */
    public static int Guid=1000;

    public static Long getGuid() {

        IdUtil.Guid+=1;

        long now = System.currentTimeMillis();
        //获取时间戳
        String info=now+"";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        if(IdUtil.Guid>9999){
            IdUtil.Guid=1000;
        }
        int ran= IdUtil.Guid;

        return Long.parseLong(info.substring(2)+ran);
    }
}
