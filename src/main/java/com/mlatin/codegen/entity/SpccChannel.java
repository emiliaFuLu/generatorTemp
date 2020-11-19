package com.mlatin.codegen.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * Author: Lu Fu
 * Date: 2020-11-19
 * Description: 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpccChannel extends BaseModel<SpccChannel> {

    
    /**
     * 名称
     */
    private String title;

    /**
     * 父id
     */
    @TableField("parentID")
    private Long parentID;

    /**
     * 图片链接
     */
    private String img;

    /**
     * 分组关联id
     */
    @TableField("claID")
    private Long claID;

    /**
     * 分类的等级
     */
    private Integer level;

    /**
     * 所属人id
     */
    @TableField("userID")
    private Long userID;

    /**
     * 所属品牌
     */
    private String jurisdiction;

    @TableField(value = "createdAt", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updatedAt", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;



}
