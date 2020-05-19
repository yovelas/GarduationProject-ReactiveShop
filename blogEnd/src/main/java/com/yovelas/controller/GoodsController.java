package com.yovelas.controller;

import com.yovelas.dao.GoodsDao;
import com.yovelas.entity.*;
import com.yovelas.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    ArticleService articleService;
    @Autowired
    GoodsDao goodsDao;

    @CrossOrigin
    @GetMapping()
    List allArticle() {
        return goodsDao.randSelectAllGoods();
    }

    /**
     * 请求所有分类信息
     * @author yovelas
     * @return
        {
            "手机数码":["小米","华为"...],
            "电脑办公":["轻薄本","游戏本"...],
            "家用电器":["电水壶","电饭煲"...],
            ...
        }
     * @throws IllegalAccessException
     */
    @CrossOrigin
    @GetMapping("/type")
    List allTypes() throws IllegalAccessException {
        ArrayList<Object> result = new ArrayList<>();           // 储存返回结果
        List<GoodsMainType> goodsMainTypes = goodsDao.selectAllGoodsMainType();     // 查询所有父级分类条目
        for(int i = 0; i< goodsMainTypes.size(); i++){      // 遍历父级分类
            HashMap<String, Object> item = new HashMap<>();     // 储存每个条目

            // 将父级分类对象转换成Map对象
            Class<?> clazz = goodsMainTypes.get(i).getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                item.put(field.getName(),field.get(goodsMainTypes.get(i)));
            }

            // 根据父级分类ID查询相关的所有子分类条目，并将子条目列表加入到Map对象的"goodSubTypes"键中，将后将这个条目加入到返回结果列表中
            List<GoodsSubType> goodsSubTypes = goodsDao.selectGoodsSubTypeByGoodsMainTypeId(goodsMainTypes.get(i).getGoodsMainTypeId());
            item.put("goodsSubTypes",goodsSubTypes);
            result.add(item);
        }
        return result;
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
