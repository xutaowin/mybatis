package com.dbapp.mybatis.test;

import com.dbapp.mybatis.mapper.BatchMapper;
import com.dbapp.mybatis.mapper.UserMapper;
import com.dbapp.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XUTAO on 2016/11/30.
 */
public class UserMapperSpringTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring-context-common.xml","spring-context-transaction.xml"});
    }
    @Test
    public void testFindUserById(){
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testBatchMapper(){
        BatchMapper batchMapper = (BatchMapper)applicationContext.getBean("batchMapper");
        UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        List<User> list = new ArrayList<User>();
        User user = null;
        for(int i=0;i<101;i++){
            user = new User();
            user.setSex(0);
            user.setUsername("testBatch"+i);
            list.add(user);
        }
        long begin = System.currentTimeMillis();
        //int count = batchMapper.updateBatch1("com.zzx.mybatis.mapper.UserMapper.insertBatchUser",list);
        //userMapper.insertBatchUser(list);
        int count = batchMapper.updateBatch("com.zzx.mybatis.mapper.UserMapper.insertBatchUser",list);
        long end = System.currentTimeMillis();
        System.out.println("101条数据插入耗时:"+(end - begin));
        System.out.println(count);
    }
}
