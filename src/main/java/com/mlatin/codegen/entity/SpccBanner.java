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
public class SpccBanner extends BaseModel<SpccBanner> {

    
    /**
     * 名称
     */
    private String title;

    /**
     * 图片链接
     */
    private String img;

    /**
     * 关联id
     */
    @TableField("objID")
    private Long objID;

    /**
     * 类型
     */
    @TableField("objType")
    private Integer objType;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 开启关闭
     */
    private Boolean display;

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
