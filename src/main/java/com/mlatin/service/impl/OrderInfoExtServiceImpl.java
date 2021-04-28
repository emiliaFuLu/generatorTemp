package com.mlatin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlatin.codegen.dao.OrderInfoExtDao;
import com.mlatin.codegen.mapper.OrderInfoExt;
import com.mlatin.service.OrderInfoExtService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现类
 *
 * @author Lu Fu
 * @since 2020-11-19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderInfoExtServiceImpl extends ServiceImpl<OrderInfoExtDao, OrderInfoExt> implements OrderInfoExtService {

}
