package com.yovelas.mapper;

import com.yovelas.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from article order by article_create_time desc")
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
    List<Article> selectAllArticle();

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
