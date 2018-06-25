package com.dbapp.mybatis.test;

/**
 * @desc:
 * @author: xutao
 */

import com.dbapp.mybatis.pojo.User;
import com.dbapp.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-*.xml")
public class TransactionTest {
    @Autowired
    private UserService userService;

    @Test
    //@Rollback(true)
    public void test(){
        User user = new User();
        user.setUsername("xutao12");
        user.setSex(1);
        userService.insertUser(user);
    }
}
