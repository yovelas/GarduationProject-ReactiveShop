package com.yovelas.service;

import com.yovelas.dao.GoodsDao;
import com.yovelas.entity.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public Map objectToMap(Object o) throws IllegalAccessException {
        HashMap<String, Object> map = new HashMap<>();     // 储存返回的Map

        // 将每个对象转换成Map对象
        Class<?> clazz = o.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            map.put(field.getName(),field.get(o));
        }
        return map;
    }

    private List goodsListToMap(List<Goods> goods) throws IllegalAccessException {
        ArrayList result = new ArrayList<>();   // 储存返回结果

        for(int i = 0; i< goods.size(); i++){      // 遍历商品列表
           result.add(oneGoodsToMap(goods.get(i)));
        }
        return result;
    }

    private Map oneGoodsToMap(Goods goods) throws IllegalAccessException {

        // 将每个商品对象转换成Map对象
        Map item = objectToMap(goods);

        // 将以逗号分隔的图片列表转换成数组
        item.put("goodsPicture",((String)item.get("goodsPicture")).split(","));

        // 查询商品相关的参数
        List<GoodsParameter> goodsParameters = goodsDao.selectAllGoodsParameterByGoodsId(goods.getGoodsId());
        ArrayList<Map> parameterlist = new ArrayList<>();   // 储存参数列表
        // 将参数列表转换成Map对象，并添加参数选项
        for(int i = 0; i < goodsParameters.size(); i++) {
            // 将参数项转换成Map对象
            Map paramter = objectToMap(goodsParameters.get(i));
            // 添加相关的选项到参数Map中
            paramter.put("goodsParameterOption", goodsDao.selectAllGoodsParameterOptionByParameterId(goodsParameters.get(i).getId()));
            //添加一项参数到参数列表
            parameterlist.add(paramter);
        }

        // 添加参数列表到商品对象中
        item.put("goodsParameter",parameterlist);

        // 将一项转换成功的商品Map对象添加到返回结果
        return item;
    }

    public List randSelectAllGoods() throws IllegalAccessException {
        return goodsListToMap(goodsDao.randSelectAllGoods());
    }

    public List selectGoodsByKeyWord(String keyWord) throws IllegalAccessException {
        return goodsListToMap(goodsDao.selectGoodsListByKeyWord("%" + keyWord + "%"));
    }

    public List selectGoodsBySubTypeId(int subTypeId) throws IllegalAccessException {
        System.out.println(goodsDao.selectGoodsByGoodsSubType(subTypeId));
        return goodsListToMap(goodsDao.selectGoodsByGoodsSubType(subTypeId));
    }

    public Map selectOneGoods(int goodsId) throws IllegalAccessException {
        Map result = oneGoodsToMap(goodsDao.selectOneGoods(goodsId));
        result.put("goodsData",goodsDao.selectGoodsDataByGoodsId(goodsId));
        return result;
    }

    public List selectAllGoodsType() throws IllegalAccessException {

        ArrayList<Object> result = new ArrayList<>();           // 储存返回结果
        List<GoodsMainType> goodsMainTypes = goodsDao.selectAllGoodsMainType();     // 查询所有父级分类条目
        for(int i = 0; i< goodsMainTypes.size(); i++){      // 遍历父级分类
            Map mainType = objectToMap(goodsMainTypes.get(i));

            // 根据父级分类ID查询相关的所有子分类条目，并将子条目列表加入到Map对象的"goodSubTypes"键中，将后将这个条目加入到返回结果列表中
            mainType.put("goodsSubTypes",goodsDao.selectGoodsSubTypeByGoodsMainTypeId(goodsMainTypes.get(i).getGoodsMainTypeId()));
            result.add(mainType);
        }
        return result;
    }
    public Map selectGoodsDataById(int id) throws IllegalAccessException {
        GoodsData goodsData = goodsDao.selectGoodsDataById(id);
        Map map = objectToMap(goodsData);
        String[] array = goodsData.getGoodsConfiguration().replace("{","").replace("}","").split(",");
        ArrayList<Object> paramlist = new ArrayList<>();

        for(String s : array){
            HashMap<Object, Object> item = new HashMap<>();
            item.put("goodsParameter",goodsDao.selectAllGoodsParameterById(Integer.valueOf(s.split(":")[0])));
            item.put("goodsParameterOption",goodsDao.selectAllGoodsParameterOptionById(Integer.valueOf(s.split(":")[1])));
            paramlist.add(item);
        }
        map.put("goodsConfiguration",paramlist);

        return map;
    }
}
