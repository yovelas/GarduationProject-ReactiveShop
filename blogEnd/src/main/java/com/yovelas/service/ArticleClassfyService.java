package com.yovelas.service;

import com.yovelas.dao.ArticleClassfyDao;
import com.yovelas.dao.ClassfyDao;
import com.yovelas.entity.ArticleClassfy;
import com.yovelas.entity.Classfy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleClassfyService {

    @Autowired
    ArticleClassfyDao articleClassfyDao;

    public int insertArticleClassfy(ArticleClassfy articleClassfy){
        return articleClassfyDao.insertArticleClassfy(articleClassfy);
    }
}
