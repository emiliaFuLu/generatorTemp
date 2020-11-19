package com.mlatin.codegen.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author: fl
 * @data: 2020-10-30 16:46
 * @description: 公共参数
 **/
@Getter
public class BaseModel<T extends Model<T>> extends Model<T> {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean archive;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public void setCreateAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updatedAt = updatedAt;
    }
}
