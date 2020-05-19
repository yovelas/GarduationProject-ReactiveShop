package com.hopu.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GoodstypeMapperTest {

    @Autowired
    private GoodstypeMapper goodstypeMapper;

    @Test
    public void select(){
        System.out.println(goodstypeMapper.selectById(1));
    }

    @Test
    public void selectByName(){
        System.out.println(goodstypeMapper.selectByName("服饰"));
    }

}