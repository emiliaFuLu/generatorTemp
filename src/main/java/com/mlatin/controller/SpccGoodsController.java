package com.mlatin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlatin.codegen.entity.SpccGoods;
import com.mlatin.common.reponse.BaseResponse;
import com.mlatin.facade.GoodsFacade;
import com.mlatin.vo.SpccGoodsVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lu Fu
 * @since 2020-11-19
 */
@RestController
public class SpccGoodsController extends BaseController {

    @Resource
    private GoodsFacade goodsFacade;

    @GetMapping("/spccGoods/list")
    public BaseResponse<List<SpccGoods>> list() {
        Page list = goodsFacade.list(1, 500);
        List<SpccGoods> records = list.getRecords();
        return new BaseResponse<>(records);
    }

}

