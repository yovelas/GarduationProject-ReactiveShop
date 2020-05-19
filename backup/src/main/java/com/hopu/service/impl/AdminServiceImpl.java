package com.hopu.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Admin;
import com.hopu.mapper.AdminMapper;
import com.hopu.service.IAdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper mapper;

    @Override
    public IPage<Admin> selectList(Page<Admin> page) {
        return mapper.selectList(page);
    }


    @Override
    public Admin selectByName(String adminName) {
        return mapper.selectByName(adminName);
    }

    @Override
    public Integer add(Admin admin) {

        //从ShiroUtils类中随机生成盐
        admin.setSalt(ShiroUtils.randomSalt());
        //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
        admin.setAdminPwd(ShiroUtils.encryptPassword(admin.getAdminPwd(), admin.getCredentialsSalt()));
       //设置时间，idDel
        admin.setCreateTime(StringUtils.getNowTime());
        admin.setUpdateTime(admin.getCreateTime());  //获取创建时间，可以提高一点性能
        admin.setIsDel(0);

        int result = mapper.insert(admin);


        return result;
    }


    @Override
    public Integer update(Admin admin,Integer adminId) {

        //判断是否输入密码，如果没有，获取的就是空字符串 ("")  就不修改密码
        if (!"".equals(admin.getAdminPwd())) {
            //从ShiroUtils类中随机生成盐
            admin.setSalt(ShiroUtils.randomSalt());
            //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
            admin.setAdminPwd(ShiroUtils.encryptPassword(admin.getAdminPwd(), admin.getCredentialsSalt()));
        } else {
            admin.setAdminPwd(null);
        }
       //设置时间
        admin.setUpdateTime(StringUtils.getNowTime());
        //将信息更新到数据库中（空的属性不修改）
        int result = mapper.updateById(admin);

        return result;
    }

}
