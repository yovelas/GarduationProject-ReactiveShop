package com.yovelas.dao;

import com.yovelas.entity.User;
import com.yovelas.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    SqlSession sqlSession;

    public User getUserByUP(User user){
        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.getUserByUP",user);
    }

    public User getUserByName(User user){
        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.getUserByName",user);
    }

    public List<User> getUserOrderByReadNum(){
        return sqlSession.selectList("com.yovelas.mapper.UserMapper.getUserOrderByReadNum");
    }

    public User getUserInfo(int id){
        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.getUserInfo",id);
    }

    public int insertUser(User user){
        return sqlSession.insert("com.yovelas.mapper.UserMapper.insertUser",user);
    }
}
