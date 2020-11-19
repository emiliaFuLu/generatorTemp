package com.mlatin.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: fl
 * @data: 2020-11-19 16:46
 * @description:
 **/
@Data
@Accessors(chain = true)
public class SpccGoodsVo {

    private String goodsNo;
    private String goodsName;

    private String title;

    private String description;

    private String mainImg;

    private String otherDesc;

    private String year;

    private String season;

    private String category;

    private String category2;

    private String range;

    private String sex;

    private String brand;

    private String wave;

    private String adapt;

    private Boolean display;

    private Boolean online;

    private Boolean erp;

    private BigDecimal unitPrice;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    private Integer fareID;

    private String mainSkc;

    private String jurisdiction;

    private Long agentId;

    private Integer fxStatus;
    private Float fxMoney;
    private Float fxPoint;
    private Float fxEst;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer weight;
    private Boolean fictitious;
}
