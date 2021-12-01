package com.mlatin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mlatin.codegen.mapper.BaseModel;
import com.mlatin.codegen.mapper.SpccGoodsSkc;
import com.mlatin.codegen.dao.SpccGoodsSkcDao;
import com.mlatin.service.SpccGoodsSkcService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  服务实现类
 * @author Lu Fu
 * @since 2020-11-19
 */
@Service
@Transactional
public class SpccGoodsSkcServiceImpl extends ServiceImpl<SpccGoodsSkcDao, SpccGoodsSkc> implements SpccGoodsSkcService {

    @Override
    public List<SpccGoodsSkc> getSkcByGoodsNo(String goodsNo) {
        LambdaQueryWrapper<SpccGoodsSkc> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SpccGoodsSkc::getGoodsNo,goodsNo)
                .eq(BaseModel::getArchive,false);

        return baseMapper.selectList(wrapper);
    }
}
