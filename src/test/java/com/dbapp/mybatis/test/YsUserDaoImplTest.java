package com.dbapp.mybatis.test;

import com.dbapp.mybatis.pojo.User;
import com.dbapp.mybatis.ysdao.UserDao;
import com.dbapp.mybatis.ysdao.impl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @desc: 原始测试UserDaoImpl
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 18:41
 */
public class YsUserDaoImplTest {
    //原始dao begin
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp(){
        //创建SqlSessionFactory
        try {
            //得到配置文件流
            InputStream inputStreams = Resources.getResourceAsStream("sqlMapConfig.xml");
            //创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStreams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindUserById(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setUsername("xutao1");
        user.setSex(1);
        userDao.insertUser(user);
    }
    @Test
    public void testDeleteUser(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        userDao.deleteUser(13);
    }
    //原始dao end
}
