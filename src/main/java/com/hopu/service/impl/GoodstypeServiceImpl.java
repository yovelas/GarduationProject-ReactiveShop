package com.hopu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Goodstype;
import com.hopu.mapper.GoodstypeMapper;
import com.hopu.service.IGoodstypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hopu.utils.ShiroUtils;
import com.hopu.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author PIGS
 * @since 2020-05-07
 */
@Service
public class GoodstypeServiceImpl extends ServiceImpl<GoodstypeMapper, Goodstype> implements IGoodstypeService {
    @Autowired
    private GoodstypeMapper mapper;

    @Override
    public IPage<Goodstype> selectList(Page<Goodstype> page) {
        return mapper.selectList(page);
    }


    @Override
    public Goodstype selectByName(String goodstypeName) {
        return mapper.selectByName(goodstypeName);
    }

    @Override
    public Integer add(Goodstype goodstype) {

        //设置时间，idDel
        goodstype.setCreateTime(StringUtils.getNowTime());
        goodstype.setUpdateTime(goodstype.getCreateTime());  //获取创建时间，可以提高一点性能
        goodstype.setIsDel(0);

        int result = mapper.insert(goodstype);


        return result;
    }


    @Override
    public Integer update(Goodstype goodstype,Integer goodstypeId) {


        //设置时间
        goodstype.setUpdateTime(StringUtils.getNowTime());
        //将信息更新到数据库中（空的属性不修改）
        int result = mapper.updateById(goodstype);

        return result;
    }
}
