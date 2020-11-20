package com.mlatin.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.mlatin.common.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: fl
 * @data: 2020-11-20 15:36
 * @description: 自动填充的字段
 **/
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createdAt", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
        Object id = getFieldValByName("id", metaObject);
        if (id == null) {
            this.strictInsertFill(metaObject, "id", Long.class, IdUtil.getGuid());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐)
    }
}

