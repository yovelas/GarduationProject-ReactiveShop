package com.hopu.service.impl;

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
 * @since 2020-05-06
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

//    @Autowired
//    private AdminMapper adminMapper;
//
//    @Override
//    public IPage<Admin> selectList(Page<Admin> page) {
//        return adminMapper.selectList(page);
//    }
//
//    @Override
//    public Admin selectByName(String adminName) {
//        return adminMapper.selectByName(adminName);
//    }
//
//    @Override
//    public Integer add(Admin admin) {
//        /*
//            1.获取盐
//            2.shiro加盐加密
//            3.用户信息存入对象，插入数据库，获取到插入的id
//            4.将empId和roleId插入到emp_role表中
//         */
//        //从ShiroUtils类中随机生成盐
//        admin.setSalt(ShiroUtils.randomSalt());
//        //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
//        admin.setAdminPwd(ShiroUtils.encryptPassword(admin.getAdminPwd(),admin.getCredentialsSalt()));
//
//        int result =  adminMapper.insert(admin);
//        return result;
//    }
//
//
//    @Override
//    public Integer update(Admin admin) {
//        //System.out.println("修改的员工信息："+employee);
//        //判断用户是否输入密码，如果没有，获取的就是空字符串 ("")  就不修改密码
//        if (!"".equals(admin.getAdminPwd()) ){
//            //从ShiroUtils类中随机生成盐
//            admin.setSalt(ShiroUtils.randomSalt());
//            //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
//            admin.setAdminPwd(ShiroUtils.encryptPassword(admin.getAdminPwd(),admin.getCredentialsSalt()));
//        }else {
//            admin.setAdminPwd(null);
//        }
//        //将信息更新到数据库中（空的属性不修改）
//        int result =  adminMapper.updateById(admin);
//        return result;
//    }
}
