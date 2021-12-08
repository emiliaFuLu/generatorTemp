package com.mlatin.service;

import com.mlatin.codegen.mapper.SpccGoods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  服务类
 * @author Lu Fu
 * @since 2020-11-19
 */
public interface SpccGoodsService extends IService<SpccGoods> {

    List<SpccGoods> getByYear(String year);

    List<SpccGoods> getByBrand(String brand);

    List<SpccGoods> getBySeason(String season);

}
