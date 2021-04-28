package com.mlatin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlatin.codegen.dao.OrderInfoDao;
import com.mlatin.codegen.mapper.OrderInfo;
import com.mlatin.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现类
 *
 * @author Lu Fu
 * @since 2020-11-19
 */
@Transactional(rollbackFor = Exception.class)
@Repository
@Slf4j
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoDao, OrderInfo> implements OrderInfoService {

}
