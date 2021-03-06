package com.yovelas.controller;

import com.yovelas.entity.JsonResult;
import com.yovelas.entity.User;
import com.yovelas.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @CrossOrigin(allowCredentials = "true")
    User oneUser(@PathVariable int id) throws IllegalAccessException {
        User user = userService.selectUserByUserId(id);
        return user;
    }

    // 基于Session判断连接状态
    @CrossOrigin(allowCredentials="true")
    @GetMapping(path = "/isconnected")
    JsonResult isConnected(HttpServletRequest req) throws IllegalAccessException {
        HttpSession session = req.getSession();
        JsonResult jsonResult = new JsonResult();
        if (session.getAttribute("user")!=null) return jsonResult.setStatus(0).setMessage("Is connected").setData(oneUser(((User)session.getAttribute("user")).getUserId()));
        else return jsonResult.setStatus(1).setMessage("Is not connected");
    }

    // 基于Cookie判断登录状态
    @CrossOrigin(allowCredentials="true")
    @GetMapping(path = "/islogined")
    JsonResult isLoginedI(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        JsonResult jsonResult = new JsonResult();
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals("user")) {
                    User user = userService.selectUserByUserName(cookie.getValue());
                    req.getSession().setAttribute("user",user);
                    return jsonResult.setStatus(0).setMessage("Is logined");
                }
            }
        }
        return jsonResult.setStatus(1).setMessage("Is not logined");
    }

    @CrossOrigin(allowCredentials="true")
    @GetMapping(path = "/isexist")
    JsonResult isExistI(HttpServletRequest req, @Param("username") String username){
        User userByName = userService.getUserByName(username);
        JsonResult jsonResult = new JsonResult();
        if (userByName!=null) return jsonResult.setStatus(0).setMessage("Is already exist");
        return jsonResult.setStatus(1).setMessage("Is not exist");
    }



//    @RequestMapping("/verification")
//    void verification(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        // get verifyCode
//        VerifyCode vc = new VerifyCode();
//        BufferedImage image = vc.getImage();
//        String text = vc.getText();
//        // save verifyCode
//        HttpSession session = req.getSession();
//        session.setAttribute("vcode", text+","+System.currentTimeMillis());
//        VerifyCode.output(image, resp.getOutputStream());
//    }

    @CrossOrigin(allowCredentials="true")
    @PostMapping(path = "/login/ia", consumes = "application/json")
    JsonResult interactiveLogin(HttpServletRequest req, @RequestBody Map map, HttpServletResponse resp) {
        JsonResult jsonResult = new JsonResult();

        // 判断参数是否为空
        System.out.println("map:"+map);
        if(map.isEmpty()){
            return jsonResult.setMessage("Parameter is null").setStatus(1);
        }

        // 帐号与密码匹配
        User userByUP = userService.getUserByUP(new User((String)map.get("username"),(String)map.get("password")));
        if(userByUP == null){
            return jsonResult.setMessage("Wrong account number or password").setStatus(3);
        }

        // 存储Session
        req.getSession().setAttribute("user", userByUP);

        // 是否加入cookie
        if(map.get("status").equals("true")){
            Cookie login = new Cookie("user", userByUP.getUserName());
            login.setMaxAge(60 * 20);
            login.setPath("/");
            resp.addCookie(login);
        }

        return jsonResult.setMessage("login successful").setStatus(0).setData(userByUP);
    }

    @CrossOrigin(allowCredentials="true")
    @PostMapping(path = "/login", consumes = "application/json")
    JsonResult login(HttpServletRequest req, @RequestBody Map map, HttpServletResponse resp) {
        JsonResult jsonResult = new JsonResult();
        boolean flag = true;
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getValue().equals(map.get("username"))) {
                    flag = false;
                }
            }
        }
        HttpSession session = req.getSession();
        if(map.get("username")==null) {
            return jsonResult.setMessage("The username is empty").setStatus(3);
        }else if(map.get("password") == null && flag){
            return jsonResult.setMessage("The password is empty").setStatus(4);
        }
        User userByName = userService.getUserByName((String)map.get("username"));
        if(userByName == null){
            return jsonResult.setMessage("The username is does not exist").setStatus(5);
        }

        if (flag) {
            // no cookie
            User userByUP = userService.getUserByUP(new User((String)map.get("username"),(String)map.get("password")));

            if (userByUP == null) {
                return jsonResult.setMessage("Password mistake").setStatus(5);
            } else {
                Cookie login = new Cookie("user", userByUP.getUserName());
                login.setMaxAge(60 * 20);
                login.setPath("/");
                resp.addCookie(login);
            }

        }
        req.getSession().setAttribute("user", userByName);
        System.out.println(flag);
        return jsonResult.setMessage("login successful").setStatus(0).setData(userByName);
    }

//    @CrossOrigin(allowCredentials="true")
//    @GetMapping(path = "/login", consumes = "application/json")
//    JsonResult autoLogin(HttpServletRequest req){
//        JsonResult jsonResult = new JsonResult();
//        String username = null;
//        User user = (User)req.getSession().getAttribute("user");
//        if(user != null){
//            username = user.getUsername();
//        }else{
//            Cookie[] cookies = req.getCookies();
//            for(Cookie c : cookies){
//                if(c.getName().equals("user")){
//                    username = c.getValue();
//                }
//            }
//        }
//        if(isConnected(req).getStatus() == 0 || isLogined(req).getStatus() == 0){
//            return jsonResult.setStatus(0).setMessage("successfully").setData(userService.getUserByName(username));
//        }
//        return jsonResult.setStatus(1).setMessage("fail");
//    }


//
//    @CrossOrigin(allowCredentials="true")
//    @PostMapping(value = "/userinfo", consumes = "application/json")
//    JsonResult getUser(HttpServletRequest req) {
//        JsonResult jsonResult = new JsonResult();
//        User user = (User) req.getSession().getAttribute("user");
//        if (user != null) {
//            user.setPassword(null);
//            jsonResult.setMessage("user information was successfully obtained");
//            jsonResult.setStatus(200);
//            jsonResult.setData(user);
//        }
//        return jsonResult;
//    }

    @CrossOrigin(allowCredentials="true")
    @PostMapping(value = "/userinfobyid", consumes = "application/json")
    JsonResult getUserById(@RequestBody Map map) {
        return new JsonResult().setStatus(0).setMessage("successfully").setData(userService.getUserById((int)map.get("id")));
    }

    // 退出登录
    @CrossOrigin(allowCredentials = "true")
    @PostMapping(path = "/logout", consumes = "application/json")
    JsonResult logout(HttpServletRequest req, HttpServletResponse resp) throws IllegalAccessException {

        JsonResult isCon =  isConnected(req);
        if(isCon.getStatus() != 0){
            return isCon;
        }
        req.getSession().removeAttribute("user");
        return new JsonResult().setMessage("Logout succuess").setStatus(0);
    }

    @CrossOrigin(allowCredentials = "true")
    @PostMapping(path = "/update", consumes = "application/json")
    Object update(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }




    JsonResult isExist(String username){
        User userByName = userService.getUserByName(username);
        JsonResult jsonResult = new JsonResult();
        if (userByName!=null) return jsonResult.setStatus(0).setMessage("Is already exist");
        return jsonResult.setStatus(1).setMessage("Is not exist");
    }

    String forget() {
        return null;
    }
    String reset() {
        return null;
    }
    String updateUser() {
        return null;
    }




//    @CrossOrigin(allowCredentials = "true")
//    @PostMapping(path = "/login", consumes = "application/json")
//    Object login(HttpServletRequest req, @RequestBody User user, HttpServletResponse resp) {
//        JsonResult jsonResult = new JsonResult();
//        boolean flag = true;
//        if (req.getCookies() != null) {
//            for (Cookie cookie : req.getCookies()) {
//                if (cookie.getValue().equals(user.getUsername())) {
//                    flag = false;
//                    System.out.println("aaa"+cookie.getValue());
//                }
//            }
//        }
//        User userByName = userService.getUserByName(userService.getUserByName(user));
//        if (flag) {
//            // not cookie
//            User userByUP = userService.getUserByUP(user);
//            if (userByUP != null) {
//                Cookie login = new Cookie("user", userByUP.getUsername());
//                login.setMaxAge(60 * 60);
//                login.setPath("/");
//                resp.addCookie(login);
//            } else {
//                return jsonResult;
//            }
//        }
//        req.getSession().setAttribute("user", userByName);
//        jsonResult.setStatus(200);
//        jsonResult.setMassage("login successful");
//        System.out.println(flag);
//        return jsonResult;
//    }
//
//    @CrossOrigin(allowCredentials = "true")
//    @PostMapping(path = "/register", consumes = "application/json")
//    Object register(HttpServletRequest req, @RequestBody User user, HttpServletResponse resp) {
//        JsonResult jsonResult = new JsonResult();
//        System.out.println(user);
//        if(userService.insertUser(user) == 1){
//            return jsonResult.setMassage("success").setStatus(200);
//        }
//        return jsonResult;
//    }
//
//    @CrossOrigin(allowCredentials = "true")
//    @PostMapping(path = "/exit", consumes = "application/json")
//    Object exit(HttpServletRequest req, HttpServletResponse resp) {
//        for (Cookie c : req.getCookies()) {
//            c.setMaxAge(0);
//        }
//        req.getSession().removeAttribute("user");
//        return new JsonResult().setMassage("succuess").setStatus(200);
//    }
//
//    @CrossOrigin(allowCredentials = "true")
//    @PostMapping(path = "/userinfo", consumes = "application/json")
//    Object userinfo(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println(req.getSession().getAttribute("user"));
//        return new JsonResult()
//                .setMassage("succuess")
//                .setStatus(200)
//                .setData(userService.getUserInfo((Integer) ((User)req.getSession().getAttribute("user")).getId()));
//    }
//
//    @CrossOrigin(allowCredentials = "true")
//    @PostMapping(path = "/userinfobyid", consumes = "application/json")
//    Object userinfoByid(@RequestBody Map map) {
//        return new JsonResult()
//                .setMassage("succuess")
//                .setStatus(200)
//                .setData(userService.getUserInfo((int)map.get("id")));
//    }
//
////    @CrossOrigin(allowCredentials = "true")
//    @RequestMapping("/userorderbyread")
//    Object getUserOrderByReadNum() {
//        return new JsonResult()
//                .setMassage("succuess")
//                .setStatus(200)
//                .setData(userService.getUserOrderByReadNum());
//    }
}
