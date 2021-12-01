package com.mlatin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mlatin.codegen.mapper.BaseModel;
import com.mlatin.codegen.mapper.SpccGoods;
import com.mlatin.codegen.dao.SpccGoodsDao;
import com.mlatin.service.SpccGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
}
