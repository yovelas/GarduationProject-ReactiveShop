package com.yovelas.mapper;

import com.yovelas.entity.Order;
import com.yovelas.entity.User;
import com.yovelas.entity.UserContact;
import com.yovelas.entity.UserTrack;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users where user_name=#{userName}")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userNickName",column = "user_nickname"),
            @Result(property = "userPicture",column = "user_picture"),
            @Result(property = "createTime",column = "create_time")})
    User getUserByUserName(@Param("userName") String userName);

    @Select("SELECT u.user_id, u.user_name, u.user_nickname, u.user_picture\n" +
            "\t, u.create_time\n" +
            "FROM users u\n" +
            "WHERE user_id = #{userId}")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userNickName",column = "user_nickname"),
            @Result(property = "userPicture",column = "user_picture"),
            @Result(property = "createTime",column = "create_time")})
    User selectUserByUserId(@Param("userId") int userId);

    @Select("SELECT t.user_track_id, t.goods_id,t.create_time\n" +
            "FROM users_track t\n" +
            "WHERE user_id = #{userId};")
    @Results({
            @Result(property = "userTrackId",column = "user_track_id"),
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "createTime",column = "create_time")})
    List<UserTrack> selectUserTracksByUserId(@Param("userId") int userId);

    @Select("SELECT c.user_contact_id, c.user_phone, c.user_email, user_address, c.create_time\n" +
            "FROM users_contact c\n" +
            "WHERE user_id = #{userId};")
    @Results({
            @Result(property = "userContactId",column = "user_contact_id"),
            @Result(property = "userPhone",column = "user_phone"),
            @Result(property = "userEmail",column = "user_email"),
            @Result(property = "userAddress",column = "user_address"),
            @Result(property = "createTime",column = "create_time")})
    List<UserContact> selectUserContactsByUserId(@Param("userId") int userId);

    @Select("SELECT o.order_id, o.goods_id, o.goods_data_id, o.order_status, o.user_contact\n" +
            "\t, shopping_num\n" +
            "FROM orders o\n" +
            "WHERE o.user_id = #{userId};")
    @Results({
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsDataId",column = "goodsDataId"),
            @Result(property = "orderStatus",column = "order_status"),
            @Result(property = "userContact",column = "userContact"),
            @Result(property = "shoppingNum",column = "shoppingNum"),
            @Result(property = "createTime",column = "create_time")})
    List<Order> selectUserOrdersByUserId(@Param("userId") int userId);







    @Select("SELECT * FROM users where user_name=#{userName} and user_password=#{userPassword}")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userNickName",column = "user_nickname"),
            @Result(property = "userPicture",column = "user_picture"),
            @Result(property = "createTime",column = "create_time")})
    User getUserByUP(@Param("userName") String userName, @Param("userPassword") String userPassword);

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
