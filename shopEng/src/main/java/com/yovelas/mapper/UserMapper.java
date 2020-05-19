package com.yovelas.mapper;

import com.yovelas.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user where username=#{username}")
    User getUserByName(@Param("username") String username);

    @Select("SELECT * FROM user where id=#{id}")
    User getUserInfo(@Param("id") int id);

    @Select("SELECT * FROM user where username=#{username} and password=#{password}")
    User getUserByUP(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where id in (select u.id from user u join article a on u.id = a.article_author order by a.article_readnum desc)")
    List<User> getUserOrderByReadNum();

    @Insert("INSERT INTO user VALUES(default,#{username},#{password},#{email},#{phone},#{image},#{role},now(),now())")
    int insertUser(
            @Param("username") String username,
            @Param("password") String password,
            @Param("email") String eamil,
            @Param("phone") String phone,
            @Param("image") String image,
            @Param("role") int role,
            @Param("create_time") String createTime,
            @Param("update_time") String updateTime);

    @Update("UPDATE blog_user SET password=#{password} where username=#{username}")
    int setpawd(@Param("password") String password, @Param("username") String username);
}
