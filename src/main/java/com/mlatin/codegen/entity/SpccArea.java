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
public class SpccArea extends BaseModel<SpccArea> {

    
    /**
     * 父id
     */
    @TableField("parentID")
    private Long parentID;

    /**
     * 名称
     */
    private String name;

    /**
     * 层级 0 1 2 省市区县
     */
    private Integer level;

    @TableField("mergeName")
    private String mergeName;



}
