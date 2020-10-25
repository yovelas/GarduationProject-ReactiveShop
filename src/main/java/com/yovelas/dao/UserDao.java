package com.yovelas.dao;

import com.yovelas.entity.Order;
import com.yovelas.entity.User;
import com.yovelas.entity.UserContact;
import com.yovelas.entity.UserTrack;
import com.yovelas.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    SqlSession sqlSession;

    public User selectUserByUserName(String userName){
        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.selectUserByUserName",userName);
    }

    public User selectUserByUserId(int userId){
        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.selectUserByUserId",userId);
    }

    public List<UserTrack> selectUserTracksByUserId(int userId){
        return sqlSession.selectList("com.yovelas.mapper.UserMapper.selectUserTracksByUserId",userId);
    }
    public List<UserContact> selectUserContactsByUserId(int userId){
        return sqlSession.selectList("com.yovelas.mapper.UserMapper.selectUserContactsByUserId",userId);
    }





    public User getUserByName(String username) {
        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.getUserByUserName", username);
    }

    public User getUserById(int id) {
        return sqlSession.selectOne("io.github.yovelas.mapper.UserMapper.getUserById", id);
    }

    public User getUserByUP(User user) {
        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.getUserByUP", user);

    }

    public int insertUser(User user){
        return sqlSession.insert("io.github.yovelas.mapper.UserMapper.insertUser",user);
    }

//    public User getUserByUP(User user){
//        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.getUserByUP",user);
//    }
//
//    public User getUserByName(User user){
//        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.getUserByName",user);
//    }
//
//    public List<User> getUserOrderByReadNum(){
//        return sqlSession.selectList("com.yovelas.mapper.UserMapper.getUserOrderByReadNum");
//    }
//
//    public User getUserInfo(int id){
//        return sqlSession.selectOne("com.yovelas.mapper.UserMapper.getUserInfo",id);
//    }
//
//    public int insertUser(User user){
//        return sqlSession.insert("com.yovelas.mapper.UserMapper.insertUser",user);
//    }
}
