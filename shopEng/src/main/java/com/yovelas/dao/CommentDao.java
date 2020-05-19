package com.yovelas.dao;

import com.yovelas.entity.Comment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommentDao {


    @Autowired
    SqlSession sqlSession;

    public int insertComment(Comment comment){
        return sqlSession.insert("com.yovelas.mapper.CommentMapper.insertComment",comment);
    }

    public List<Comment> selectCommentByUser(int id){
        return sqlSession.selectList("com.yovelas.mapper.CommentMapper.selectCommentByUser",id);
    }

    public int updateCommentStatus(int id){
        return sqlSession.update("com.yovelas.mapper.CommentMapper.updateCommentStatus",id);
    }

    public int selectCommentCount(int id){
        return sqlSession.selectOne("com.yovelas.mapper.CommentMapper.selectCommentCount",id);
    }
}
