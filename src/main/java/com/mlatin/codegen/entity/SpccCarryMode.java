package com.mlatin.codegen.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Author: Lu Fu
 * Date: 2020-11-19
 * Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SpccCarryMode extends BaseModel<SpccCarryMode> {


    /**
     * 模板表外键
     */
    @TableField("fareTempID")
    private Long fareTempID;

    /**
     * 起步价
     */
    @TableField("firstFare")
    private BigDecimal firstFare;

    /**
     * 加价
     */
    @TableField("stepFare")
    private BigDecimal stepFare;

    /**
     * 最高价
     */
    @TableField("maxFare")
    private BigDecimal maxFare;

    @TableField(value = "createdAt", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updatedAt", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;


}
