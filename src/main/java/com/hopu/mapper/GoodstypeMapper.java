package com.hopu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Goodstype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author PIGS
 * @since 2020-05-07
 */
public interface GoodstypeMapper extends BaseMapper<Goodstype> {
    IPage<Goodstype> selectList(Page<Goodstype> page);

    Goodstype selectByName(String goodstypeName);
}
