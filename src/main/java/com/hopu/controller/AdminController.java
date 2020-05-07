package com.hopu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Admin;
import com.hopu.service.IAdminService;
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
public class AdminController {

    @Autowired
    private IAdminService adminService;

    /**
     *  查询一页管理员信息
     *   url :  /admin/每页条数/当前页码
     *          /admin/10/1
     */
    @GetMapping("/admin")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Admin> p = new Page<Admin>();
        p.setSize(limit);
        p.setCurrent(page);

        IPage<Admin> iPage=adminService.selectList(p);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    /**
     *  新增用户
     */
    @PostMapping("/admin")
    public Map add(Admin admin){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",adminService.add(admin));
        return result;
    }

    /**
     *  删除用户
     */
    @DeleteMapping("/admin/del/{AdminId}")
    public Map del(@PathVariable Integer AdminId){
        Admin admin = new Admin();
        admin.setAdminId(AdminId);
        admin.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",adminService.updateById(admin));
        return result;
    }

    /**
     *  修改用户
     */
    @PutMapping("/admin")
    public Map edit(Admin admin,Integer adminId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",adminService.update(admin,adminId));

        return result;
    }
}
