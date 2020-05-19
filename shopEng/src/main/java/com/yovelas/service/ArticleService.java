package com.yovelas.service;

import com.yovelas.dao.ArticleDao;
import com.yovelas.entity.Article;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    @Autowired
    ArticleDao articleDao;

    public List<Article> selectAllArticle(){
        return articleDao.selectAllArticle();
    }

    public List<Article> selectHotArticle(){
        return articleDao.selectHotArticle();
    }

    public List<Article> selectArticleByUser(Map map){
        return articleDao.selectArticleByUser(map);
    }

    public Article selectArticleById(int id){
        return articleDao.selectArticleById(id);
    }

    public int selectArticleCount(int id){
        return articleDao.selectArticleCount(id);
    }

    public Article selectSpecifyArticle(Article article){
        return articleDao.selectSpecifyArticle(article);
    }

    public List<Article> selectSpecifyClassfyArticle(int classfyId){
        return articleDao.selectSpecifyClassfyArticle(classfyId);
    }

    public int insertArticle(Article article){
        return articleDao.insertArticle(article);
    }

    public int deleteArticle(int id){
        return articleDao.deleteArticle(id);
    }

    public int updateArticle(Article article){
        return articleDao.updateArticle(article);
    }

    public int addLikeArticle(int id){
        return articleDao.addLikeArticle(id);
    }

    public int addReadArticle(int id){
        return articleDao.addReadArticle(id);
    }
}
