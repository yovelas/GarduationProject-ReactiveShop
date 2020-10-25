package com.yovelas.controller;

import com.yovelas.dao.GoodsDao;
import com.yovelas.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsDao goodsDao;
    @Autowired
    GoodsService goodsService;


    /**
     * 随机获取商品
     * @return
     * @throws IllegalAccessException
     */
    @CrossOrigin
    @GetMapping()
    List randGoods() throws IllegalAccessException {
        return goodsService.randSelectAllGoods();
    }

    /**
     * 根据id查询相关的商品
     * @param goodsId
     * @return
     * @throws IllegalAccessException
     */
    @CrossOrigin
    @GetMapping("/{goodsId}")
    Map oneGoodsById(@PathVariable("goodsId") int goodsId) throws IllegalAccessException {
        return goodsService.selectOneGoods(goodsId);
    }

    /**
     * 根据关键字查询相关的商品
     * @param keyWord
     * @return
     * @throws IllegalAccessException
     */
    @CrossOrigin
    @GetMapping("/list/{keyWord}")
    List GoodsListByKeyWord(@PathVariable("keyWord") String keyWord) throws IllegalAccessException {
        return goodsService.selectGoodsByKeyWord(keyWord);
    }

    /**
     * 所有分类信息
     * @author yovelas
     * @return
        {
            "手机数码":["小米","华为"...],
            "电脑办公":["轻薄本","游戏本"...],
            "家用电器":["电水壶","电饭煲"...],
            ...
        }
     * @throws IllegalAccessException
     */
    @CrossOrigin
    @GetMapping("/type")
    List allGoodsTypes() throws IllegalAccessException {
        return goodsService.selectAllGoodsType();
    }

    @CrossOrigin
    @GetMapping("/type/{typeId}")
    List oneGoodsByTypeId(@PathVariable("typeId") int typeId) throws IllegalAccessException {
        return goodsService.selectGoodsBySubTypeId(typeId);
    }
}
