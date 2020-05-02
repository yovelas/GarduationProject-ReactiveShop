package com.hopu.mapper;

import com.hopu.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodsMapper {

    @Select("select * from goods")
    Goods selectall();
}
