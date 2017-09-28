package com.dbapp.mybatis.test;

import com.dbapp.mybatis.mapper.UserMapper;
import com.dbapp.mybatis.pojo.User;
import com.dbapp.mybatis.pojo.UserCustom;
import com.dbapp.mybatis.pojo.UserQueryVo;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 22:04
 */
public class UserMapperTest {
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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void testFindUserByName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByName(StringEscapeUtils.escapeSql("1' or '1'='1"));
        sqlSession.close();
        System.out.println(users);
    }

    @Test
    public void testFindUserByHashMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("id",1);
        paramMap.put("username","tao");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByHashMap(paramMap);
        sqlSession.close();
        System.out.println(users);
    }

    //用户信息综合查询
    @Test
    public void testFindUserList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserQueryVo vo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        //userCustom.setSex(1);
        //userCustom.setUsername("dbapp");
        vo.setUserCustom(userCustom);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(6);
        vo.setIds(ids);
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserCustom> users = userMapper.findUserList(vo);
        sqlSession.close();
        System.out.println(users);
    }

    //用户信息综合查询
    @Test
    public void testFindUserCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserQueryVo vo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex(1);
        userCustom.setUsername("dbapp");
        vo.setUserCustom(userCustom);
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.findUserCount(vo);
        sqlSession.close();
        System.out.println(count);
    }

    //根据id查询用户信息,使用resultMap
    @Test
    public void testFindUserByIdResultMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByIdResultMap(1);
        sqlSession.close();
        System.out.println(user);
    }

    public static void main(String[] args) {
        Map<String,String> sortMap = new HashMap<String,String>();
        sortMap.put("unitName","unit_name");
        sortMap.put("scanPath","scan_path");
        sortMap.put("type","type");
        sortMap.put("description","description");
        sortMap.put("levelName","level");
        sortMap.put("tamperTime","tamper_time");
        sortMap.put("scanTime","scan_time");
        sortMap.put("status","status");
        System.out.println(sortMap.get("aaa"));
    }
}
