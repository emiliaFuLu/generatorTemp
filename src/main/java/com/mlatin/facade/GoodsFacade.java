package com.mlatin.facade;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.gson.Gson;
import com.mlatin.codegen.entity.SpccGoods;
import com.mlatin.codegen.entity.SpccShopGoods;
import com.mlatin.service.SpccGoodsService;
import com.mlatin.service.SpccShopGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author: fl
 * @data: 2020-11-19 16:42
 * @description:
 **/
@Service
public class GoodsFacade {

    @Resource
    private SpccGoodsService spccGoodsService;
    @Resource
    private SpccShopGoodsService spccShopGoodsService;

    public Page list(int pageNo, int pageSize) {
        QueryWrapper<SpccShopGoods> queryWrapper = new QueryWrapper<>();
        Page page = spccShopGoodsService.page(new Page<>(1, 10), queryWrapper
                .select("goodsNo")
                .eq("customerId","JNYHC01")
                .eq("online",true)
                .eq("display",true)
        );

        List<SpccShopGoods> records = page.getRecords();
        List<String> goodsNos = records.stream().map(SpccShopGoods::getGoodsNo).collect(toList());

        List<SpccGoods> byGoodsNos = findByGoodsNos(goodsNos);

        page.setRecords(byGoodsNos);
        return page;
    }

    public List<SpccGoods> findByGoodsNos(List<String> goodNos){
        if (CollectionUtils.isEmpty(goodNos)){
            return new ArrayList<>();
        }
        QueryWrapper<SpccGoods> queryWrapper = new QueryWrapper();
        queryWrapper.in("goodsNo",goodNos);
        List<SpccGoods> list = spccGoodsService.list(queryWrapper);

        return list;
    }
}
