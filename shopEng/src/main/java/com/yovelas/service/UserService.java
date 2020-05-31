package com.yovelas.service;

import com.yovelas.dao.OrderDao;
import com.yovelas.dao.UserDao;
import com.yovelas.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    OrderService orderService;

    public User selectUserByUserName(String userName){
        return userDao.selectUserByUserName(userName);
    }

    public User selectUserByUserId(int userId) throws IllegalAccessException {
        User user = userDao.selectUserByUserId(userId);
        user.setUserContact(userDao.selectUserContactsByUserId(userId));
        user.setUserTrack(userDao.selectUserTracksByUserId(userId));
        user.setUserOrders(orderService.selectUserOrdersByUserId(userId));
        return user;
    }

    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public User getUserByUP(User user) {
        return userDao.getUserByUP(user);
    }

    public int insertUser(User user){
//        user.setNickname(user.getUsername());
//        int i = userDao.insertUser(user);
//        User userByName = getUserByName(user.getUsername());
//
//        // 添加默认专辑
//        Album album = new Album();
//        album.setUserId(userByName.getId());
//        album.setAlbumName("default album");
//        album.setAlbumDescribe("when user sign up automatic created");
//        album.setAlbumTag("tags");
//        album.setCentralPhotoId(1);
//        albumDao.insertAlbum(album);
//        return i;
        return 0;
    }








    //    public User getUserByUP(User user){
//        return userDao.getUserByUP(user);
//    }
//
//    public User getUserByName(User user){
//        return userDao.getUserByName(user);
//    }
//
//    public List<User> getUserOrderByReadNum(){
//        return userDao.getUserOrderByReadNum();
//    }
//
//    public User getUserInfo(int id){
//        return userDao.getUserInfo(id);
//    }
//
//    public int insertUser(User user){
//        return userDao.insertUser(user);
//    }
}
