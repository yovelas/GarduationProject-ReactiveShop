package com.hopu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author PIGS
 * @since 2020-05-07
 */
public interface IAdminService extends IService<Admin> {

    IPage<Admin> selectList(Page<Admin> page);

    Admin selectByName(String adminName);

    Integer add(Admin admin);


    Integer update(Admin admin);


}
