package com.mlatin.service.impl;

import com.mlatin.codegen.entity.SpccContentProductGroup;
import com.mlatin.codegen.dao.SpccContentProductGroupDao;
import com.mlatin.service.SpccContentProductGroupService;
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
public class SpccContentProductGroupServiceImpl extends ServiceImpl<SpccContentProductGroupDao, SpccContentProductGroup> implements SpccContentProductGroupService {

}
