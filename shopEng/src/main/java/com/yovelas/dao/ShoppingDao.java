package com.yovelas.dao;

import com.yovelas.entity.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingDao {


    @Autowired
    SqlSession sqlSession;

    public List<Shopping> selectAllShopping(){
        return sqlSession.selectList("com.yovelas.mapper.ShoppingMapper.selectAllShopping");
    }

}
