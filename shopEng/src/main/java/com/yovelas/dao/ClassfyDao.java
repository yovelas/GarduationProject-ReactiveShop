package com.yovelas.dao;

import com.yovelas.entity.Classfy;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassfyDao {


    @Autowired
    SqlSession sqlSession;

    public List<Classfy> selectAllClassfy(){
        return sqlSession.selectList("com.yovelas.mapper.ClassfyMapper.selectAllClassfy");
    }

    public List<Classfy> selectSpecifyClassfy(String name){
        return sqlSession.selectList("com.yovelas.mapper.ClassfyMapper.selectSpecifyClassfy",name);
    }

    public Classfy selectSpecifyIdClassfy(int id){
        return sqlSession.selectOne("com.yovelas.mapper.ClassfyMapper.selectSpecifyIdClassfy",id);
    }

    public int insertClassfy( String name){
        return sqlSession.insert("com.yovelas.mapper.ClassfyMapper.insertClassfy",name);
    }
}
