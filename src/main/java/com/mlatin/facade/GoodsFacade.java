package com.mlatin.facade;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlatin.codegen.mapper.SpccGoods;
import com.mlatin.service.SpccGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    public Page list(int pageNo, int pageSize) {
        QueryWrapper<SpccGoods> queryWrapper = new QueryWrapper<>();
        Page page = spccGoodsService.page(new Page<>(1, 10), queryWrapper
                .select("goodsNo")
                .eq("online",true)
                .eq("display",true)
        );

        List<SpccGoods> records = page.getRecords();
        List<String> goodsNos = records.stream().map(SpccGoods::getGoodsNo).collect(toList());

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
