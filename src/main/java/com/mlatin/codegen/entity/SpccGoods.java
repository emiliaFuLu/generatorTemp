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
public class SpccGoods extends BaseModel<SpccGoods> {


    @TableField("goodsNo")
    private String goodsNo;

    @TableField("goodsName")
    private String goodsName;

    private String title;

    private String description;

    @TableField("mainImg")
    private String mainImg;

    @TableField("otherDesc")
    private String otherDesc;

    @TableField("`year`")
    private String year;

    private String season;

    private String category;

    private String category2;

    @TableField("`range`")
    private String range;

    private String sex;

    private String brand;

    private String wave;

    private String adapt;

    private Boolean display;

    @TableField("`online`")
    private Boolean online;

    @TableField("onlineTime")
    private Long onlineTime;

    private Boolean erp;

    @TableField("unitPrice")
    private BigDecimal unitPrice;

    @TableField("minPrice")
    private BigDecimal minPrice;

    @TableField("maxPrice")
    private BigDecimal maxPrice;

    @TableField("fareID")
    private Integer fareID;

    @TableField("mainSkc")
    private String mainSkc;

    private String jurisdiction;

    @TableField("agentId")
    private Long agentId;

    @TableField("fxStatus")
    private Integer fxStatus;

    @TableField("fxMoney")
    private Float fxMoney;

    @TableField("fxPoint")
    private Float fxPoint;

    @TableField("fxEst")
    private Float fxEst;

    @TableField(value = "createdAt", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updatedAt", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    private Integer weight;

    private Boolean fictitious;


}
