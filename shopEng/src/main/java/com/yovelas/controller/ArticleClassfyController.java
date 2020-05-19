package com.yovelas.controller;

import com.yovelas.entity.ArticleClassfy;
import com.yovelas.service.ArticleClassfyService;
import com.yovelas.service.ClassfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/articleclassfy")
public class ArticleClassfyController {

    @Autowired
    ArticleClassfyService articleClassfyService;


    @RequestMapping("/insertarticleclassfy")
    Object insertClassfy(@RequestBody ArticleClassfy articleClassfy) {
        System.out.println(articleClassfy);
        return articleClassfyService.insertArticleClassfy(articleClassfy);
    }
}
