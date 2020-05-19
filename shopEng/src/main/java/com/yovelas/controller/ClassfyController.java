package com.yovelas.controller;

import com.yovelas.entity.Article;
import com.yovelas.entity.JsonResult;
import com.yovelas.entity.LayUiEntity;
import com.yovelas.entity.User;
import com.yovelas.service.ArticleService;
import com.yovelas.service.ClassfyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/classfy")
public class ClassfyController {

    @Autowired
    ClassfyService classfyService;

    @RequestMapping("/allclassfy")
    List allArticle() {
        return classfyService.selectAllClassfy();
    }

    @RequestMapping("/searchclassfy")
    List searchArticle(@RequestBody Map map) {
        return classfyService.selectSpecifyClassfy((String)map.get("name"));
    }

    @RequestMapping("/searchclassfybyid")
    Object searchArticleSpecifyId(@RequestBody Map map) {
        return classfyService.selectSpecifyIdClassfy((int)map.get("id"));
    }

    @RequestMapping("/insertclassfy")
    Object insertClassfy(@RequestBody Map map) {
        System.out.println(map);
        return classfyService.insertClassfy((String)map.get("name"));
    }
}
