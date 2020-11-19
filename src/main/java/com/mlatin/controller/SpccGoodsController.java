package com.mlatin.controller;


import com.mlatin.common.reponse.BaseResponse;
import com.mlatin.facade.GoodsFacade;
import com.mlatin.vo.SpccGoodsVo;
import org.springframework.web.bind.annotation.GetMapping;
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
    public BaseResponse<List<SpccGoodsVo>> list() {
        return new BaseResponse<>(goodsFacade.list());
    }

}

