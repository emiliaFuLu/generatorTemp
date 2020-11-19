package com.mlatin.service.impl;

import com.mlatin.codegen.entity.SpccDictSize;
import com.mlatin.codegen.dao.SpccDictSizeDao;
import com.mlatin.service.SpccDictSizeService;
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
public class SpccDictSizeServiceImpl extends ServiceImpl<SpccDictSizeDao, SpccDictSize> implements SpccDictSizeService {

}
