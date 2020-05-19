package com.hopu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Goodstype;
import com.hopu.service.IAdminService;
import com.hopu.service.IGoodstypeService;
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
public class GoodstypeController {

    @Autowired
    private IGoodstypeService goodstypeService;

    /**
     *  查询一页商品类型信息
     *   url :  /admin/每页条数/当前页码
     *          /admin/10/1
     */
    @GetMapping("/goodstype")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Goodstype> p = new Page<Goodstype>();
        p.setSize(limit);
        p.setCurrent(page);

        IPage<Goodstype> iPage=goodstypeService.selectList(p);
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    /**
     *  新增商品类型
     */
    @PostMapping("/goodstype")
    public Map add(Goodstype goodstype){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",goodstypeService.add(goodstype));
        return result;
    }

    /**
     *  删除商品类型
     */
    @DeleteMapping("/goodstype/del/{GoodstypeId}")
    public Map del(@PathVariable Integer GoodstypeId){
        Goodstype goodstype = new Goodstype();
        goodstype.setGoodstypeId(GoodstypeId);
        goodstype.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",goodstypeService.updateById(goodstype));
        return result;
    }

    /**
     *  修改商品类型信息
     */
    @PutMapping("/goodstype")
    public Map edit(Goodstype goodstype,Integer goodstypeId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",goodstypeService.update(goodstype,goodstypeId));

        return result;
    }
}
