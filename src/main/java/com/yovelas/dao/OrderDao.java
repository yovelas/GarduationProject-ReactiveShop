package com.yovelas.dao;

import com.yovelas.entity.Order;
import com.yovelas.entity.User;
import com.yovelas.entity.UserContact;
import com.yovelas.entity.UserTrack;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    SqlSession sqlSession;

    public List<Order> selectUserOrdersByUserId(int userId) {
        return sqlSession.selectList("com.yovelas.mapper.UserMapper.selectUserOrdersByUserId", userId);
    }

    public int insertOneUserOrders(Order order) {
        return sqlSession.insert("com.yovelas.mapper.OrderMapper.insertOneUserOrders", order);
    }
}


