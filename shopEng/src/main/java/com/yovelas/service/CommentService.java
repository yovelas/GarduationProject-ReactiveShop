package com.yovelas.service;

import com.yovelas.dao.ArticleDao;
import com.yovelas.dao.CommentDao;
import com.yovelas.entity.Article;
import com.yovelas.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    public int insertComment(Comment comment){
        return commentDao.insertComment(comment);
    }

    public List<Comment> selectCommentByUser(int id){
        return commentDao.selectCommentByUser(id);
    }

    public int updateCommentStatus(int id){
        return commentDao.updateCommentStatus(id);
    }

    public int selectCommentCount(int id){
        return commentDao.selectCommentCount(id);
    }

}
