package com.mlatin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlatin.codegen.dao.SpccGoodsDao;
import com.mlatin.codegen.mapper.BaseModel;
import com.mlatin.codegen.mapper.SpccGoods;
import com.mlatin.service.SpccGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现类
 *
 * @author Lu Fu
 * @since 2020-11-19
 */
@Service
@Transactional
public class SpccGoodsServiceImpl extends ServiceImpl<SpccGoodsDao, SpccGoods> implements SpccGoodsService {

    @Override
    public List<SpccGoods> getByYear(String year) {
        LambdaQueryWrapper<SpccGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SpccGoods::getYear, year)
                .eq(BaseModel::getArchive, false);

        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<SpccGoods> getByBrand(String brand) {
        LambdaQueryWrapper<SpccGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SpccGoods::getBrand, brand)
                .eq(BaseModel::getArchive, false);

        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<SpccGoods> getBySeason(String season) {
        LambdaQueryWrapper<SpccGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SpccGoods::getSeason, season)
                .eq(BaseModel::getArchive, false);

        return baseMapper.selectList(wrapper);
    }
}
