package com.hopu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author PIGS
 * @since 2020-05-07
 */
public interface UsersMapper extends BaseMapper<Users> {
    IPage<Users> selectList(Page<Users> page);

    Users selectByName(String adminName);
}
