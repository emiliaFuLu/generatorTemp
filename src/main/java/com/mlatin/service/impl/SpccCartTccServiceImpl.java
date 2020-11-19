package com.mlatin.service.impl;

import com.mlatin.codegen.entity.SpccCartTcc;
import com.mlatin.codegen.dao.SpccCartTccDao;
import com.mlatin.service.SpccCartTccService;
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
public class SpccCartTccServiceImpl extends ServiceImpl<SpccCartTccDao, SpccCartTcc> implements SpccCartTccService {

}
