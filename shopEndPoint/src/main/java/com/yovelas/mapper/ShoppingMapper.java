package com.yovelas.mapper;

import com.yovelas.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingMapper {

    @Select("SELECT s.shopping_id, s.users_id, s.goods_id, s.shopping_num, s.goods_data_id, g.goods_name\n" +
            "\t, g.goods_sub_name, goods_picture, d.goods_configuration, d.goods_price\n" +
            "FROM shopping s\n" +
            "\tJOIN goods g ON s.goods_id = g.goods_id\n" +
            "\tJOIN goods_data d ON s.goods_data_id = d.id;")
    @Results({
            @Result(property = "shoppingId",column = "shopping_id"),
            @Result(property = "usersId",column = "users_id"),
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "shoppingNum",column = "shopping_num"),
            @Result(property = "goodsDataId",column = "goods_data_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsConfiguration",column = "goods_configuration"),
            @Result(property = "goodsPrice",column = "goods_price")})
    List<Shopping> selectAllShopping();

    @Insert("insert into shopping value(null,#{usersId},#{goodsId},#{goodsDataId},#{shoppingNum})")
    int insertOneShopping(@Param("usersId") int usersId,@Param("goodsId") int goodsId,@Param("goodsDataId") int goodsDataId,@Param("shoppingNum") int shoppingNum);


}
