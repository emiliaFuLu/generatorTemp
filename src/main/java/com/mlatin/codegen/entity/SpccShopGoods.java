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
public class SpccShopGoods extends BaseModel<SpccShopGoods> {


    @TableField("goodsNo")
    private String goodsNo;

    @TableField("customerID")
    private String customerID;

    private String jurisdiction;

    @TableField("agentId")
    private Long agentId;

    private String description;

    @TableField("descImg")
    private String descImg;

    private Boolean display;

    private Boolean online;

    @TableField("onlineTime")
    private Long onlineTime;

    private Integer weight;

    @TableField("mainGoods")
    private Boolean mainGoods;

    @TableField("fxStatus")
    private Integer fxStatus;

    @TableField("fxMoney")
    private Float fxMoney;

    @TableField("fxPoint")
    private Float fxPoint;

    @TableField("fxEst")
    private Float fxEst;

    @TableField("stockNum")
    private Integer stockNum;

    @TableField(value = "createdAt", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updatedAt", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    @TableField("saleNum")
    private Integer saleNum;

    @TableField("balancePrice")
    private BigDecimal balancePrice;


}
