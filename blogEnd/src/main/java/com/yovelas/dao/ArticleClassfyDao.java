package com.yovelas.dao;

import com.yovelas.entity.ArticleClassfy;
import com.yovelas.entity.Classfy;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleClassfyDao {


    @Autowired
    SqlSession sqlSession;

    public int insertArticleClassfy(ArticleClassfy articleClassfy){
        return sqlSession.insert("com.yovelas.mapper.ArticleClassfyMapper.insertArticleClassfy",articleClassfy);
    }
}
