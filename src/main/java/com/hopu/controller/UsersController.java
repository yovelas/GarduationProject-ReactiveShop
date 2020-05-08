package com.hopu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Users;
import com.hopu.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author PIGS
 * @since 2020-05-07
 */
@RestController
public class UsersController {
    @Autowired
    private IUsersService usersService;

    /**
     *  查询一页用户信息
     *   url :  /admin/每页条数/当前页码
     *          /admin/10/1
     */
    @GetMapping("/users")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Users> p = new Page<Users>();
        p.setSize(limit);
        p.setCurrent(page);

        IPage<Users> iPage=usersService.selectList(p);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    /**
     *  新增用户
     */
    @PostMapping("/users")
    public Map add(Users users){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",usersService.add(users));
        return result;
    }

    /**
     *  删除用户
     */
    @DeleteMapping("/users/del/{UsersId}")
    public Map del(@PathVariable Integer UsersId){
        Users users = new Users();
        users.setUsersId(UsersId);
        users.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",usersService.updateById(users));
        return result;
    }

    /**
     *  修改用户信息
     */
    @PutMapping("/users")
    public Map edit(Users users,Integer usersId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",usersService.update(users,usersId));

        return result;
    }
}
