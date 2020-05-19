package com.yovelas.mapper;

import com.yovelas.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CommentMapper {

    @Insert("insert into article_comments values(null,#{articleId},#{email},#{comments},1,now())")
    int insertComment(@Param("articleId") int articleId,
                      @Param("email") String email,
                      @Param("comments") String comments);

    @Select("select ac.*,(select a.article_name from article a  where a.article_id = ac.article_id) comment from article_comments ac where ac.article_id in (select article_id from article where article_author=#{id}) order by ac.status desc")
    @Results({
            @Result(property = "articleId",column = "comment"),
            @Result(property = "createTime",column = "create_time"),
    })
    Comment selectCommentByUser(@Param("id") int id);

    @Update("update article_comments set status=0 where id = #{id}")
    int updateCommentStatus(@Param("id") int id);

    @Select("select count(*) from article_comments where status=1 and article_id in (select article_id from article where article_author=#{id})")
    int selectCommentCount(@Param("id") int id);
}
