package com.hopu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Admin;
import com.hopu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/admin1")
    public Map add(Admin admin){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",adminService.add(admin));
        return result;
    }
}
