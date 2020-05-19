package com.yovelas.dao;

import com.yovelas.entity.Article;
import com.yovelas.entity.Goods;
import com.yovelas.entity.GoodsMainType;
import com.yovelas.entity.GoodsSubType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GoodsDao {


    @Autowired
    SqlSession sqlSession;

    public List<Goods> selectAllGoods(){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoods");
    }

    public List<Goods> randSelectAllGoods(){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.randSelectAllGoods");
    }

    public List<GoodsMainType> selectAllGoodsMainType(){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoodsMainType");
    }

    public List<Goods> selectGoodsByGoodsSubType(int goodsSubTypeId){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectGoodsByGoodsSubType");
    }

    public List<GoodsSubType> selectAllGoodsSubType(){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoodsSubType");
    }

    public List<GoodsSubType> selectGoodsSubTypeByGoodsMainTypeId(int goodsMainTypeId){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectGoodsSubTypeByGoodsMainTypeId", goodsMainTypeId);
    }











    public List<Article> selectHotArticle(){
        return sqlSession.selectList("com.yovelas.mapper.ArticleMapper.selectHotArticle");
    }
    public List<Article> selectArticleByUser(Map map){
        return sqlSession.selectList("com.yovelas.mapper.ArticleMapper.selectArticleByUser",map);
    }
    public Article selectArticleById(int id){
        return sqlSession.selectOne("com.yovelas.mapper.ArticleMapper.selectArticleById",id);
    }

    public int selectArticleCount(int id){
        return sqlSession.selectOne("com.yovelas.mapper.ArticleMapper.selectArticleCount",id);
    }

    public Article selectSpecifyArticle(Article article){
        return sqlSession.selectOne("com.yovelas.mapper.ArticleMapper.selectSpecifyArticle",article);
    }

    public List<Article> selectSpecifyClassfyArticle(int classfyId){
        return sqlSession.selectList("com.yovelas.mapper.ArticleMapper.selectSpecifyClassfyArticle",classfyId);
    }

    public int insertArticle(Article article){
        return sqlSession.insert("com.yovelas.mapper.ArticleMapper.insertArticle",article);
    }

    public int deleteArticle(int id){
        return sqlSession.delete("com.yovelas.mapper.ArticleMapper.deleteArticle",id);
    }

    public int updateArticle(Article article){
        return sqlSession.delete("com.yovelas.mapper.ArticleMapper.updateArticle",article);
    }

    public int addLikeArticle(int id){
        return sqlSession.update("com.yovelas.mapper.ArticleMapper.addLikeArticle",id);
    }

    public int addReadArticle(int id){
        return sqlSession.update("com.yovelas.mapper.ArticleMapper.addReadArticle",id);
    }
}
