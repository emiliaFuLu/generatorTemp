package com.mlatin.facade;

import com.mlatin.codegen.entity.SpccGoods;
import com.mlatin.common.utils.TransferUtil;
import com.mlatin.service.impl.SpccGoodsServiceImpl;
import com.mlatin.vo.SpccGoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: fl
 * @data: 2020-11-19 16:42
 * @description:
 **/
@Service
public class GoodsFacade {

    @Resource
    private SpccGoodsServiceImpl spccGoodsService;

    public List<SpccGoodsVo> list() {
        List<SpccGoods> list = spccGoodsService.list();
        List<SpccGoodsVo> ret = new ArrayList<>();
        if (list != null) {
            list.forEach(d -> ret.add(TransferUtil.copyBean(d, SpccGoodsVo.class)));
        }
        return ret;
    }
}
