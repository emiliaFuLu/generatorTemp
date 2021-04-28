package com.mlatin.codegen.mapper;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;



/**
 * Author: Lu Fu
 * Date: 2020-11-19
 * Description: 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfo extends BaseModel<OrderInfo> {

    
    private String orderId;

    private String orderName;

    @TableField(value = "createdAt", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;



}
