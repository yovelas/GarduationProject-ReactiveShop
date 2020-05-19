package com.yovelas.service;

import com.yovelas.dao.ArticleDao;
import com.yovelas.dao.ClassfyDao;
import com.yovelas.entity.Article;
import com.yovelas.entity.Classfy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassfyService {

    @Autowired
    ClassfyDao classfyDao;

    public List<Classfy> selectAllClassfy(){
        return classfyDao.selectAllClassfy();
    }

    public List<Classfy> selectSpecifyClassfy(String name){
        return classfyDao.selectSpecifyClassfy(name);
    }

    public Classfy selectSpecifyIdClassfy(int id){
        return classfyDao.selectSpecifyIdClassfy(id);
    }

    public int insertClassfy(String name){
        return classfyDao.insertClassfy(name);
    }
}
