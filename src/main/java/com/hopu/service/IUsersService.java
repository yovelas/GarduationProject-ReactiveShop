package com.hopu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-05-07
 */
public interface IUsersService extends IService<Users> {
    IPage<Users> selectList(Page<Users> page);

    Users selectByName(String usersName);

    Integer add(Users users);


    Integer update(Users users,Integer usersId);
}
