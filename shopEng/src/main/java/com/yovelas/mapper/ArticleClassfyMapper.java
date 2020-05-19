package com.yovelas.mapper;

import com.yovelas.entity.Classfy;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleClassfyMapper {

    @Insert("insert into article_classfy values(null,#{articleId},#{classfyId})")
    int insertArticleClassfy(@Param("articleId") int articleId,@Param("classfyId") int classfyId);
}
