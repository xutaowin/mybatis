package com.dbapp.mybatis.test;

import com.dbapp.mybatis.mapper.OrdersMapper;
import com.dbapp.mybatis.mapper.UserMapper;
import com.dbapp.mybatis.pojo.Orders;
import com.dbapp.mybatis.pojo.OrdersCustom;
import com.dbapp.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by XUTAO on 2016/11/30.
 */
public class OrderMapperTest {
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
    public void testFindOrderUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建OrdersMapper对象，mybatis自动生成mapper代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersCustom> ordersCustoms = ordersMapper.findOrdersUser();
        sqlSession.close();
        System.out.println(ordersCustoms);
    }

    @Test
    public void testFindOrderUserResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建OrdersMapper对象，mybatis自动生成mapper代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.findOrdersUserResultMap();
        sqlSession.close();
        System.out.println(ordersList);
    }

    @Test
    public void testFindOrdersAndOrderDetailResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建OrdersMapper对象，mybatis自动生成mapper代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.findOrdersAndOrderDetailResultMap();
        sqlSession.close();
        System.out.println(ordersList);
    }

    @Test
    public void testFindUserAndItemsResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> userList = ordersMapper.findUserAndItemsResultMap();
        sqlSession.close();
        System.out.println(userList);
    }

    @Test
    public void testFindOrdersUserLazyLoading() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建OrdersMapper对象，mybatis自动生成mapper代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        //查询订单信息（单表）
        List<Orders> ordersList = ordersMapper.findOrdersUserLazyLoading();
        //遍历上边的订单列表
        for(Orders orders:ordersList){
            //执行getUser()去查询用户信息。这里实现按需加载
            User user = orders.getUser();
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**
     * mybatis 默认开启一级缓存
     */
    @Test
    public void testCache1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //下边查询使用一个sqlSession
        //第一次发起请求id为1的用户信息
        User user1 = userMapper.findUserById(1);
        System.out.println("user1:"+user1);
        //如果sqlSession去执行commit操作(执行插入，更新，删除)，清空sqlSession中的一级缓存，
        //这样做的目的为了让缓存中的存储的是最新的信息，避免读取到脏数据
        /*user1.setUsername("xutao");
        userMapper.updateUser(user1);*/
        //执行commit清空缓存
        //sqlSession.commit();
        //第二次发起请求id为1的用户信息
        User user2 = userMapper.findUserById(1);
        System.out.println("user2:"+user2);
        sqlSession.close();
    }

    /**
     * 二级缓存测试
     */
    @Test
    public void testCache2(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        //第一次发起请求id为1的用户信息
        User user1 = userMapper1.findUserById(1);
        System.out.println("user1:"+user1);
        //这里执行关闭操作，将sqlSession中的数据写到二级缓存区域
        sqlSession1.close();
        /*//执行sqlSession3 commit()提交
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        User user = userMapper3.findUserById(1);
        user.setUsername("xutao2cache");
        userMapper3.updateUser(user);
        //清空二级缓存
        sqlSession3.commit();
        sqlSession3.close();*/
        //第二次发起请求id为1的用户信息
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.findUserById(1);
        System.out.println("user2:"+user2);
        sqlSession2.close();

    }
}
