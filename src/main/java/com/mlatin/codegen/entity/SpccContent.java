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
public class SpccContent extends BaseModel<SpccContent> {

    
    @TableField("typeId")
    private Long typeId;

    @TableField("operatorId")
    private Long operatorId;

    private String jurisdiction;

    private String title;

    private String text;

    private String image;

    private String audio;

    private String video;

    private String detail;

    @TableField("showType")
    private Integer showType;

    private Integer state;

    @TableField("startTime")
    private LocalDateTime startTime;

    @TableField("endTime")
    private LocalDateTime endTime;

    private String addr;

    private Integer weight;

    private Boolean archived;

    @TableField(value = "createdAt", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updatedAt", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;



}
