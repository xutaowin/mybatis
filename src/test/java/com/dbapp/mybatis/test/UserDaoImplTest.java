package com.dbapp.mybatis.test;

import com.dbapp.mybatis.dao.UserDao;
import com.dbapp.mybatis.dao.impl.UserDaoImpl;
import com.dbapp.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: 和spring整合测试UserDaoImpl
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 18:41
 */
public class UserDaoImplTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
    @Test
    public void testFindUserById(){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        User user = new User();
        user.setUsername("xutao1");
        user.setSex(1);
        userDao.insertUser(user);
    }
    @Test
    public void testDeleteUser(){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.deleteUser(13);
    }
}
