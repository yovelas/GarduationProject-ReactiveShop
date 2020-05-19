package com.yovelas.controller;

import com.yovelas.dao.UserDao;
import com.yovelas.entity.JsonResult;
import com.yovelas.entity.User;
import com.yovelas.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;


    @CrossOrigin(allowCredentials = "true")
    @PostMapping(path = "/login", consumes = "application/json")
    Object login(HttpServletRequest req, @RequestBody User user, HttpServletResponse resp) {
        JsonResult jsonResult = new JsonResult();
        boolean flag = true;
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getValue().equals(user.getUsername())) {
                    flag = false;
                    System.out.println("aaa"+cookie.getValue());
                }
            }
        }
        User userByName = userService.getUserByName(userService.getUserByName(user));
        if (flag) {
            // not cookie
            User userByUP = userService.getUserByUP(user);
            if (userByUP != null) {
                Cookie login = new Cookie("user", userByUP.getUsername());
                login.setMaxAge(60 * 60);
                login.setPath("/");
                resp.addCookie(login);
            } else {
                return jsonResult;
            }
        }
        req.getSession().setAttribute("user", userByName);
        jsonResult.setStatus(200);
        jsonResult.setMassage("login successful");
        System.out.println(flag);
        return jsonResult;
    }

    @CrossOrigin(allowCredentials = "true")
    @PostMapping(path = "/register", consumes = "application/json")
    Object register(HttpServletRequest req, @RequestBody User user, HttpServletResponse resp) {
        JsonResult jsonResult = new JsonResult();
        System.out.println(user);
        if(userService.insertUser(user) == 1){
            return jsonResult.setMassage("success").setStatus(200);
        }
        return jsonResult;
    }

    @CrossOrigin(allowCredentials = "true")
    @PostMapping(path = "/exit", consumes = "application/json")
    Object exit(HttpServletRequest req, HttpServletResponse resp) {
        for (Cookie c : req.getCookies()) {
            c.setMaxAge(0);
        }
        req.getSession().removeAttribute("user");
        return new JsonResult().setMassage("succuess").setStatus(200);
    }

    @CrossOrigin(allowCredentials = "true")
    @PostMapping(path = "/userinfo", consumes = "application/json")
    Object userinfo(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req.getSession().getAttribute("user"));
        return new JsonResult()
                .setMassage("succuess")
                .setStatus(200)
                .setData(userService.getUserInfo((Integer) ((User)req.getSession().getAttribute("user")).getId()));
    }

    @CrossOrigin(allowCredentials = "true")
    @PostMapping(path = "/userinfobyid", consumes = "application/json")
    Object userinfoByid(@RequestBody Map map) {
        return new JsonResult()
                .setMassage("succuess")
                .setStatus(200)
                .setData(userService.getUserInfo((int)map.get("id")));
    }

//    @CrossOrigin(allowCredentials = "true")
    @RequestMapping("/userorderbyread")
    Object getUserOrderByReadNum() {
        return new JsonResult()
                .setMassage("succuess")
                .setStatus(200)
                .setData(userService.getUserOrderByReadNum());
    }
}
