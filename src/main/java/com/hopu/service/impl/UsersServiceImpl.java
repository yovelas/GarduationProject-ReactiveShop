package com.hopu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hopu.entity.Users;
import com.hopu.mapper.UsersMapper;
import com.hopu.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private UsersMapper mapper;

    @Override
    public IPage<Users> selectList(Page<Users> page) {
        return mapper.selectList(page);
    }


    @Override
    public Users selectByName(String usersName) {
        return mapper.selectByName(usersName);
    }

    @Override
    public Integer add(Users users) {

        //从ShiroUtils类中随机生成盐
        users.setSalt(ShiroUtils.randomSalt());
        //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
        users.setUsersPwd(ShiroUtils.encryptPassword(users.getUsersPwd(), users.getCredentialsSalt()));
        //设置时间，idDel
        users.setCreateTime(StringUtils.getNowTime());
        users.setUpdateTime(users.getCreateTime());  //获取创建时间，可以提高一点性能
        users.setIsDel(0);

        int result = mapper.insert(users);


        return result;
    }


    @Override
    public Integer update(Users admin,Integer adminId) {

        //判断是否输入密码，如果没有，获取的就是空字符串 ("")  就不修改密码
        if (!"".equals(admin.getUsersPwd())) {
            //从ShiroUtils类中随机生成盐
            admin.setSalt(ShiroUtils.randomSalt());
            //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
            admin.setUsersPwd(ShiroUtils.encryptPassword(admin.getUsersPwd(), admin.getCredentialsSalt()));
        } else {
            admin.setUsersPwd(null);
        }
        //设置时间
        admin.setUpdateTime(StringUtils.getNowTime());
        //将信息更新到数据库中（空的属性不修改）
        int result = mapper.updateById(admin);

        return result;
    }
}
