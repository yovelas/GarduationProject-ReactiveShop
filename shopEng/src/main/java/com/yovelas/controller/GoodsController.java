package com.yovelas.controller;

import com.yovelas.dao.GoodsDao;
import com.yovelas.entity.*;
import com.yovelas.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    ArticleService articleService;
    @Autowired
    GoodsDao goodsDao;

    @CrossOrigin
    @GetMapping()
    List allGoods() throws IllegalAccessException {
        ArrayList<Object> result = new ArrayList<>();           // 储存返回结果

        List<Goods> goods = goodsDao.randSelectAllGoods();
        for(int i = 0; i< goods.size(); i++){      // 遍历父级分类
            HashMap<String, Object> item = new HashMap<>();     // 储存每个条目

            // 将父级分类对象转换成Map对象
            Class<?> clazz = goods.get(i).getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                item.put(field.getName(),field.get(goods.get(i)));
            }
            item.put("goodsPicture",((String)item.get("goodsPicture")).split(","));

            result.add(item);
        }

        return result;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    Map oneGoodsById(@PathVariable("id") int id) throws IllegalAccessException {

        HashMap<String, Object> item = new HashMap<>();     // 储存每个条目
        ArrayList<Map> parameterlist = new ArrayList<>();
        Goods goods = goodsDao.selectOneGoods(id);
        List<GoodsParameter> goodsParameters = goodsDao.selectAllGoodsParameterByGoodsId(id);

        // 将对象转换成Map对象
        Class<?> clazz = goods.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            item.put(field.getName(),field.get(goods));
        }

        // 将参数对象转换成Map对象
        for(int i = 0; i < goodsParameters.size(); i++) {
            HashMap<String, Object> itemP = new HashMap<>();     // 储存每个条目
            Class<?> clazzP = goodsParameters.get(i).getClass();
            for (Field field : clazzP.getDeclaredFields()) {
                field.setAccessible(true);
                itemP.put(field.getName(), field.get(goodsParameters.get(i)));
            }
            itemP.put("goodsParameterOption", goodsDao.selectAllGoodsParameterOptionByParameterId(goodsParameters.get(i).getId()));
            parameterlist.add(itemP);
        }

        // 转换图片为list
        item.put("goodsPicture",((String)item.get("goodsPicture")).split(","));
        // 添加参数
        item.put("goodsParameter",parameterlist);
        return item;
    }

    @CrossOrigin
    @GetMapping("/list/{keyWord}")
    List GoodsListByKeyWord(@PathVariable("keyWord") String keyWord) throws IllegalAccessException {
        System.out.println(keyWord);

        List<Goods> goods = goodsDao.selectGoodsListByKeyWord("%" + keyWord + "%");
        ArrayList result = new ArrayList<>();

        for(int i = 0; i< goods.size();i++){
            HashMap<String, Object> item = new HashMap<>();     // 储存每个条目
            ArrayList<Map> parameterlist = new ArrayList<>();
            // 将对象转换成Map对象
            Class<?> clazz = goods.get(i).getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                item.put(field.getName(),field.get(goods.get(i)));
            }

            List<GoodsParameter> goodsParameters = goodsDao.selectAllGoodsParameterByGoodsId(goods.get(i).getGoodsId());

            // 将参数对象转换成Map对象
            for(int j = 0; j < goodsParameters.size(); j++) {
                HashMap<String, Object> itemP = new HashMap<>();     // 储存每个条目
                Class<?> clazzP = goodsParameters.get(i).getClass();
                for (Field field : clazzP.getDeclaredFields()) {
                    field.setAccessible(true);
                    itemP.put(field.getName(), field.get(goodsParameters.get(i)));
                }
                itemP.put("goodsParameterOption", goodsDao.selectAllGoodsParameterOptionByParameterId(goodsParameters.get(i).getId()));
                parameterlist.add(itemP);
            }

            // 转换图片为list
            item.put("goodsPicture",((String)item.get("goodsPicture")).split(","));
            item.put("goodsPrice",((String)item.get("goodsPrice")).split("-")[0]);
            // 添加参数
            item.put("goodsParameter",parameterlist);
            result.add(item);
        }


        return result;
    }

    /**
     * 请求所有分类信息
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
    List allTypes() throws IllegalAccessException {
        ArrayList<Object> result = new ArrayList<>();           // 储存返回结果
        List<GoodsMainType> goodsMainTypes = goodsDao.selectAllGoodsMainType();     // 查询所有父级分类条目
        for(int i = 0; i< goodsMainTypes.size(); i++){      // 遍历父级分类
            HashMap<String, Object> item = new HashMap<>();     // 储存每个条目

            // 将父级分类对象转换成Map对象
            Class<?> clazz = goodsMainTypes.get(i).getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                item.put(field.getName(),field.get(goodsMainTypes.get(i)));
            }

            // 根据父级分类ID查询相关的所有子分类条目，并将子条目列表加入到Map对象的"goodSubTypes"键中，将后将这个条目加入到返回结果列表中
            List<GoodsSubType> goodsSubTypes = goodsDao.selectGoodsSubTypeByGoodsMainTypeId(goodsMainTypes.get(i).getGoodsMainTypeId());
            item.put("goodsSubTypes",goodsSubTypes);
            result.add(item);
        }
        return result;
    }
}
