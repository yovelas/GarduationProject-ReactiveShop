package com.yovelas.mapper;

import com.yovelas.entity.Article;
import com.yovelas.entity.Goods;
import com.yovelas.entity.GoodsMainType;
import com.yovelas.entity.GoodsSubType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select * from goods order by goods_id")
    @Results({
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsStore",column = "goods_store"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsDescribe",column = "goods_describe"),
            @Result(property = "goodsTypeId",column = "goods_type_id")
    })
    List<Goods> selectAllGoods();

    @Select("select * from goods order by rand() limit 12;")
    @Results({
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsStore",column = "goods_store"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsDescribe",column = "goods_describe"),
            @Result(property = "goodsTypeId",column = "goods_type_id")
    })
    List<Goods> randSelectAllGoods();

    @Select("SELECT * FROM goods WHERE goods_type_id = #{goodsSubTypeId};") @Results({
            @Result(property = "goodsId",column = "goods_id"),
            @Result(property = "goodsName",column = "goods_name"),
            @Result(property = "goodsSubName",column = "goods_sub_name"),
            @Result(property = "goodsPrice",column = "goods_price"),
            @Result(property = "goodsStore",column = "goods_store"),
            @Result(property = "goodsPicture",column = "goods_picture"),
            @Result(property = "goodsDescribe",column = "goods_describe"),
            @Result(property = "goodsTypeId",column = "goods_type_id")
    })
    List<Goods> selectGoodsByGoodsSubType(@Param("goodsSubTypeId") int goodsSubTypeId);

    @Select("select * from goods_main_type")
    @Results({
            @Result(property = "goodsMainTypeId",column = "goods_main_type_id"),
            @Result(property = "goodsMainTypeName",column = "goods_main_type_name"),
            @Result(property = "goodsMainTypePicture",column = "goods_main_type_picture")
    })
    List<GoodsMainType> selectAllGoodsMainType();

    @Select("select * from goods_sub_type")
    @Results({
            @Result(property = "goodsSubTypeId",column = "goods_sub_type_id"),
            @Result(property = "goodsSubTypeName",column = "goods_sub_type_name"),
            @Result(property = "goodsSubTypePicture",column = "goods_sub_type_picture"),
    })
    List<GoodsSubType> selectAllGoodsSubType();

//    @Select("SELECT * FROM goods_sub_type WHERE goods_sub_type_id IN ( SELECT goods_type_main_with_sub_relationship_sub_id FROM goods_type_main_with_sub_relationship r WHERE r.goods_type_main_with_sub_relationship_main_id = #{goodsMainTypeId} );")
    @Select("SELECT *\n" +
            "FROM goods_sub_type\n" +
            "WHERE goods_sub_type_id IN (\n" +
            "\tSELECT goods_type_main_with_sub_relationship_sub_id\n" +
            "\tFROM goods_type_main_with_sub_relationship r\n" +
            "\tWHERE r.goods_type_main_with_sub_relationship_main_id = #{goodsMainTypeId}\n" +
            ");")
    @Results({
            @Result(property = "goodsSubTypeId",column = "goods_sub_type_id"),
            @Result(property = "goodsSubTypeName",column = "goods_sub_type_name"),
            @Result(property = "goodsSubTypePicture",column = "goods_sub_type_picture"),
    })
    List<GoodsSubType> selectGoodsSubTypeByGoodsMainTypeId(@Param("goodsMainTypeId") int goodsMainTypeId);


















    @Select("select * from article order by article_likenum desc limit 0,8")
    @Results({
            @Result(property = "id",column = "article_id"),
            @Result(property = "name",column = "article_name"),
            @Result(property = "author",column = "article_author"),
            @Result(property = "image",column = "article_image"),
            @Result(property = "content",column = "article_content"),
            @Result(property = "readnum",column = "article_readnum"),
            @Result(property = "likenum",column = "article_likenum"),
            @Result(property = "status",column = "article_status"),
            @Result(property = "createTime",column = "article_create_time"),
            @Result(property = "updateTime",column = "article_update_time"),
    })
    List<Article> selectHotArticle();

    @Select("select * from article where article_author=#{id} limit #{page},#{limit}")
    @Results({
            @Result(property = "id",column = "article_id"),
            @Result(property = "name",column = "article_name"),
            @Result(property = "author",column = "article_author"),
            @Result(property = "image",column = "article_image"),
            @Result(property = "content",column = "article_content"),
            @Result(property = "readnum",column = "article_readnum"),
            @Result(property = "likenum",column = "article_likenum"),
            @Result(property = "status",column = "article_status"),
            @Result(property = "createTime",column = "article_create_time"),
            @Result(property = "updateTime",column = "article_update_time"),
    })
    List<Article> selectArticleByUser(@Param("userId") int id,
                                      @Param("page") int page,
                                      @Param("limit") int limit);

    @Select("select * from article where article_name=#{name} and article_image=#{image} and article_content=#{content}")
    @Results({
            @Result(property = "id",column = "article_id"),
            @Result(property = "name",column = "article_name"),
            @Result(property = "author",column = "article_author"),
            @Result(property = "image",column = "article_image"),
            @Result(property = "content",column = "article_content"),
            @Result(property = "readnum",column = "article_readnum"),
            @Result(property = "likenum",column = "article_likenum"),
            @Result(property = "status",column = "article_status"),
            @Result(property = "createTime",column = "article_create_time"),
            @Result(property = "updateTime",column = "article_update_time"),
    })
    Article selectSpecifyArticle(@Param("name") String name,
                                 @Param("image") String image,
                                 @Param("content") String content);

    @Select("select * from article where article_id in (select article_id from article_classfy where classfy_id = #{classfyId});")
    @Results({
            @Result(property = "id",column = "article_id"),
            @Result(property = "name",column = "article_name"),
            @Result(property = "author",column = "article_author"),
            @Result(property = "image",column = "article_image"),
            @Result(property = "content",column = "article_content"),
            @Result(property = "readnum",column = "article_readnum"),
            @Result(property = "likenum",column = "article_likenum"),
            @Result(property = "status",column = "article_status"),
            @Result(property = "createTime",column = "article_create_time"),
            @Result(property = "updateTime",column = "article_update_time"),
    })
    List<Article> selectSpecifyClassfyArticle(@Param("classfyId") int classfyId);

    @Select("select * from article where article_id=#{id}")
    @Results({
            @Result(property = "id",column = "article_id"),
            @Result(property = "name",column = "article_name"),
            @Result(property = "author",column = "article_author"),
            @Result(property = "image",column = "article_image"),
            @Result(property = "content",column = "article_content"),
            @Result(property = "readnum",column = "article_readnum"),
            @Result(property = "likenum",column = "article_likenum"),
            @Result(property = "status",column = "article_status"),
            @Result(property = "createTime",column = "article_create_time"),
            @Result(property = "updateTime",column = "article_update_time"),
    })
    Article selectArticleById(@Param("id") int id);

    @Select("select count(*) from article where article_author=#{id}")
    int selectArticleCount(@Param("id") int id);

    @Insert("insert into article values(null,#{name},#{author},#{image},#{content},#{classfy},#{readnum},#{likenum},#{status},now(),now())")
    int insertArticle(@Param("name") String name,
                      @Param("author") String author,
                      @Param("image") String image,
                      @Param("content") String content,
                      @Param("classfy") String classfy,
                      @Param("readnum") String readnum,
                      @Param("likenum") String likenum,
                      @Param("status") String status);

    @Delete("delete from article where article_id=#{id}")
    int deleteArticle(@Param("id") int id);

    @Update("update article set article_name=#{name},article_image=#{image},article_content=#{content},article_update_time=now() where article_id=#{id}")
    int updateArticle(@Param("id") int id,
                      @Param("name") String name,
                      @Param("image") String image,
                      @Param("content") String content);

    @Update("update article set article_likenum=(article_likenum+1) where article_id=#{id}")
    int addLikeArticle(@Param("id") int id);

    @Update("update article set article_readnum=(article_readnum+1) where article_id=#{id}")
    int addReadArticle(@Param("id") int id);
}
