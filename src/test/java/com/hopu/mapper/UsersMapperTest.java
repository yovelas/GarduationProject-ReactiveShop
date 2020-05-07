package com.hopu.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UsersMapperTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void select(){
        System.out.println(usersMapper.selectById(1));
    }
}