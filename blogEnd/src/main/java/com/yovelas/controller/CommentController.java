package com.yovelas.controller;

import com.yovelas.entity.*;
import com.yovelas.service.ArticleService;
import com.yovelas.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/addcomment")
    Object addRead(@RequestBody Comment comment) {
        System.out.println(comment);
        if(commentService.insertComment(comment) == 1){
            return new JsonResult().setStatus(200).setMassage("success");
        }
        return new JsonResult();
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/getcomment")
    Object selectComment(HttpServletRequest req) {
        return new JsonResult()
                .setStatus(200)
                .setMassage("success")
                .setData(commentService
                        .selectCommentByUser(((User)req.
                                getSession().
                                getAttribute("user"))
                                .getId()));
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/readcomment")
    Object readComment(HttpServletRequest req,@RequestBody Map map) {
        System.out.println(map.get("id"));
        int id = (int) map.get("id");
        return new JsonResult()
                .setStatus(200)
                .setMassage("success")
                .setData(commentService.updateCommentStatus(id));
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/countcomment")
    Object countComment(HttpServletRequest req) {

       User user = (User)req.getSession().getAttribute("user");
       if(user != null){
           int data = commentService.selectCommentCount(user.getId());
           System.out.println(data);
           return new JsonResult()
                   .setStatus(200)
                   .setMassage("success")
                   .setData(data);
       }
        return null;

    }

}
