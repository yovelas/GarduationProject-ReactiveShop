package com.hopu.mapper;

import com.hopu.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void select(){
        System.out.println(adminMapper.selectById(1));
    }

    @Test
    public void selectByName(){
        System.out.println(adminMapper.selectByName("张三"));
    }


}