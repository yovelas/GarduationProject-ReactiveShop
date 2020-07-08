package com.yovelas.service;

import com.yovelas.dao.OrderDao;
import com.yovelas.dao.UserDao;
import com.yovelas.entity.Order;
import com.yovelas.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    GoodsService goodsService;

    public List selectUserOrdersByUserId(int userId) throws IllegalAccessException {
        List<Order> orders = orderDao.selectUserOrdersByUserId(userId);
        ArrayList<Object> result = new ArrayList<>();
        for(Order o : orders){
            Map map = goodsService.objectToMap(o);
            map.put("goods",goodsService.selectOneGoods(o.getGoodsId()));
            map.remove("goodsId");
            map.put("goodsConfiguration",goodsService.selectGoodsDataById(o.getGoodsId()));
            map.remove("goodsData");
            result.add(map);
        }
        return result;
    }

    public int insertOneUserOrders(Order order) {
        order.setOrderStatus(1);
        return orderDao.insertOneUserOrders(order);
    }

}
