package com.yovelas.controller;

import com.fasterxml.jackson.core.json.JsonReadContext;
import com.yovelas.dao.ArticleDao;
import com.yovelas.entity.Article;
import com.yovelas.entity.JsonResult;
import com.yovelas.entity.LayUiEntity;
import com.yovelas.entity.User;
import com.yovelas.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/allarticle")
    List allArticle() {
        return articleService.selectAllArticle();
    }

    @RequestMapping("/hotarticle")
    List hotArticle() {
        return articleService.selectHotArticle();
    }

    @RequestMapping("/articlebyid")
    Object getArticleById(@Param("id") int id) {
        return articleService.selectArticleById(id);
    }

    @RequestMapping("/articlebyclassfyid")
    Object selectSpecifyClassfyArticle(@Param("id") int id) {
        return articleService.selectSpecifyClassfyArticle(id);
    }

    @CrossOrigin
    @RequestMapping("/articlebyuser/{id}")
    Object ArticleByUser(HttpServletRequest req,@PathVariable int id,int page,int limit) {
        System.out.println(page);
        System.out.println(limit);
        HashMap<String, Object> map = new HashMap<>();
        map.put("page",page-1);
        map.put("limit",limit);
        map.put("id",id);

        List<Article> articles = articleService.selectArticleByUser(map);
        LayUiEntity layUiEntity = new LayUiEntity();
        layUiEntity.setCode(0);
        layUiEntity.setCount(articleService.selectArticleCount(id));
        layUiEntity.setData(articles);
        return layUiEntity;
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/write")
    Object writeArticle(HttpServletRequest req,@RequestBody Article article) {
        article.setAuthor(((User)req.getSession().getAttribute("user")).getId());
        System.out.println(article);
        articleService.insertArticle(article);
        return new JsonResult().setStatus(200).setMassage("success").setData(articleService.selectSpecifyArticle(article));
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/delete")
    Object deleteArticle(HttpServletRequest req,@RequestBody Map id) {
        System.out.println(id.get("id"));
        articleService.deleteArticle((int)id.get("id"));
        return new JsonResult();
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/edit")
    Object editArticle(HttpServletRequest req,@RequestBody Article article) {
        System.out.println(article);
        articleService.updateArticle(article);
        return new JsonResult();
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/addlike")
    Object addLike(@RequestBody Map map) {
        System.out.println("likelike");
        System.out.println(map);
        System.out.println(articleService.addLikeArticle((int)map.get("id")));
        return new JsonResult();
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/addread")
    Object addRead(@RequestBody Map map) {
        System.out.println("readread");
        System.out.println(map);
        System.out.println(articleService.addReadArticle((int)map.get("id")));
        return new JsonResult();
    }

}
