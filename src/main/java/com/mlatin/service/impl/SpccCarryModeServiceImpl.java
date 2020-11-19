package com.mlatin.service.impl;

import com.mlatin.codegen.entity.SpccCarryMode;
import com.mlatin.codegen.dao.SpccCarryModeDao;
import com.mlatin.service.SpccCarryModeService;
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
public class SpccCarryModeServiceImpl extends ServiceImpl<SpccCarryModeDao, SpccCarryMode> implements SpccCarryModeService {

}
