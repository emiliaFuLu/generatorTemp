package com.mlatin.service;

import com.mlatin.codegen.mapper.SpccGoodsSkc;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 服务类
 *
 * @author Lu Fu
 * @since 2020-11-19
 */
public interface SpccGoodsSkcService extends IService<SpccGoodsSkc> {

    /**
     * 根据商品查询颜色
     *
     * @param goodsNo
     * @return
     */
    List<SpccGoodsSkc> getSkcByGoodsNo(String goodsNo);
}
