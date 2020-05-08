package com.hopu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Goodstype;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-05-07
 */
public interface IGoodstypeService extends IService<Goodstype> {
    IPage<Goodstype> selectList(Page<Goodstype> page);

    Goodstype selectByName(String goodstypeName);

    Integer add(Goodstype goodstype);


    Integer update(Goodstype goodstype,Integer goodstypeId);
}
