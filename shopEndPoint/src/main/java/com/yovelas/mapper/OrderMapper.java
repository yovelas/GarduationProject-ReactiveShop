package com.yovelas.mapper;

import com.yovelas.entity.Order;
import com.yovelas.entity.User;
import com.yovelas.entity.UserContact;
import com.yovelas.entity.UserTrack;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

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

    @Insert("INSERT INTO orders\n" +
            "VALUES (NULL, #{userId}, #{goodsId}, #{goodsDataId}, #{orderStatus}\n" +
            "\t, #{userContactId}, #{shoppingNum}, now());;")
    int insertOneUserOrders(@Param("userId") int userId,
                                    @Param("goodsId") int goodsId,
                                    @Param("goodsDataId") int goodsDataId,
                                    @Param("orderStatus") int orderStatus,
                                    @Param("userContactId") int userContactId);

}
