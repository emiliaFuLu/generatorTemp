package com.mlatin.service.impl;

import com.mlatin.codegen.entity.SpccGoodsSku;
import com.mlatin.codegen.dao.SpccGoodsSkuDao;
import com.mlatin.service.SpccGoodsSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *  服务实现类
 * @author Lu Fu
 * @since 2020-11-19
 */
@Service
@Transactional
public class SpccGoodsSkuServiceImpl extends ServiceImpl<SpccGoodsSkuDao, SpccGoodsSku> implements SpccGoodsSkuService {

}
