package com.dbapp.mybatis.test;

import com.dbapp.mybatis.dao.UserDao;
import com.dbapp.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @desc: 和spring整合测试UserDaoImpl
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 18:41
 */
@Transactional
public class UserDaoImplTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring-context-common.xml","spring-context-transaction.xml"});
    }
    @Test
    public void testFindUserById(){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
    @Test
    @Transactional
    @Rollback(true)
    public void testInsertUser(){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        User user = new User();
        user.setUsername("xutao6");
        user.setSex(1);
        userDao.insertUser(user);
        String s = null;
        s.lastIndexOf("1");
        /*user = new User();
        user.setUsername("xutao2");
        user.setSex(2);
        String s = null;
        s.lastIndexOf("1");
        userDao.insertUser(user);*/
    }
    @Test
    public void testDeleteUser(){
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.deleteUser(13);
    }
}
