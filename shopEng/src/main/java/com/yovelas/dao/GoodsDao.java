package com.yovelas.dao;

import com.yovelas.entity.*;
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

    public List<Goods> selectGoodsListByKeyWord(String keyWord){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectGoodsListByKeyWord", keyWord);
    }

    public Goods selectOneGoods(int goodsId){
        return sqlSession.selectOne("com.yovelas.mapper.GoodsMapper.selectOneGoods", goodsId);
    }

    public List<GoodsMainType> selectAllGoodsMainType(){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoodsMainType");
    }

    public List<Goods> selectGoodsByGoodsSubType(int goodsSubTypeId){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectGoodsByGoodsSubType", goodsSubTypeId);
    }

    public List<GoodsSubType> selectAllGoodsSubType(){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoodsSubType");
    }

    public List<GoodsSubType> selectGoodsSubTypeByGoodsMainTypeId(int goodsMainTypeId){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectGoodsSubTypeByGoodsMainTypeId", goodsMainTypeId);
    }

    public List<GoodsParameter> selectAllGoodsParameterById(int id){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoodsParameterById", id);
    }

    public List<GoodsParameter> selectAllGoodsParameterByGoodsId(int goodsId){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoodsParameterByGoodsId", goodsId);
    }

    public List<GoodsParameterOption> selectAllGoodsParameterOptionById(int id){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoodsParameterOptionById", id);
    }

    public List<GoodsParameterOption> selectAllGoodsParameterOptionByParameterId(int goodsParameterId){
        return sqlSession.selectList("com.yovelas.mapper.GoodsMapper.selectAllGoodsParameterOptionByParameterId", goodsParameterId);
    }

    public GoodsData selectGoodsDataById(int id){
        return sqlSession.selectOne("com.yovelas.mapper.GoodsMapper.selectGoodsDataById", id);
    }
}
