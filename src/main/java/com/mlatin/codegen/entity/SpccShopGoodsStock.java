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
public class SpccShopGoodsStock extends BaseModel<SpccShopGoodsStock> {

    
    @TableField("skuId")
    private Long skuId;

    @TableField("skuCode")
    private String skuCode;

    @TableField("stockNum")
    private Integer stockNum;

    @TableField("customerID")
    private String customerID;

    private Boolean online;

    @TableField("synStorage")
    private Boolean synStorage;

    @TableField(value = "createdAt", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updatedAt", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;



}
