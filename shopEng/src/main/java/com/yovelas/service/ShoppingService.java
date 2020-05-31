package com.yovelas.service;

import com.yovelas.dao.GoodsDao;
import com.yovelas.dao.ShoppingDao;
import com.yovelas.entity.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingService {

    @Autowired
    ShoppingDao shoppingDao;

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    GoodsService goodsService;

    public List selectAllShopping() throws IllegalAccessException {
        List<Shopping> shoppings = shoppingDao.selectAllShopping();
        ArrayList<Object> result = new ArrayList<>();
        for(int i = 0; i<shoppings.size(); i++){
            String[] array = shoppings.get(i).getGoodsConfiguration().replace("{","").replace("}","").split(",");
            ArrayList<Object> paramlist = new ArrayList<>();
            Map map = goodsService.objectToMap(shoppings.get(i));

            for(String s : array){
                HashMap<Object, Object> item = new HashMap<>();
                item.put("goodsParameter",goodsDao.selectAllGoodsParameterById(Integer.valueOf(s.split(":")[0])));
                item.put("goodsParameterOption",goodsDao.selectAllGoodsParameterOptionById(Integer.valueOf(s.split(":")[1])));
                paramlist.add(item);
            }

            map.put("goodsPicture",((String)map.get("goodsPicture")).split(","));
            map.put("goodsConfiguration",paramlist);
            result.add(map);
        }

        return result;
    }
}
