package com.yovelas.service;

import com.yovelas.dao.UserDao;
import com.yovelas.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;


    public User getUserByUP(User user){
        return userDao.getUserByUP(user);
    }

    public User getUserByName(User user){
        return userDao.getUserByName(user);
    }

    public List<User> getUserOrderByReadNum(){
        return userDao.getUserOrderByReadNum();
    }

    public User getUserInfo(int id){
        return userDao.getUserInfo(id);
    }

    public int insertUser(User user){
        return userDao.insertUser(user);
    }
}
