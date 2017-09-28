package com.dbapp.mybatis.first;

import com.dbapp.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @desc: mybatis入门程序
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/16
 * @Time： 20:56
 */
public class MybatisFirst {
    //根据id查询用户信息
    @Test
    public void findUserById() {
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            //得到配置文件流
            InputStream inputStreams = Resources.getResourceAsStream("sqlMapConfig.xml");
            //创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStreams);
            //通过工厂得到SQLSession
            sqlSession = sqlSessionFactory.openSession();
            //通过SQLSession操作数据库
            //第一个参数：映射文件中statement的id，等于namespace+“.”+statement的id
            //第二个参数：指定与映射文件匹配的parameterType类型的参数值
            //sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
            User user = sqlSession.selectOne("test.findUserById", 1);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //根据用户名称模糊查询用户列表信息
    @Test
    public void findUserByName() {
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            //得到配置文件流
            InputStream inputStreams = Resources.getResourceAsStream("sqlMapConfig.xml");
            //创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStreams);
            //通过工厂得到SQLSession
            sqlSession = sqlSessionFactory.openSession();
            //通过SQLSession操作数据库
            //第一个参数：映射文件中statement的id，等于namespace+“.”+statement的id
            //第二个参数：指定与映射文件匹配的parameterType类型的参数值
            //List<User>中的User与映射文件中所匹配的resultType类型的对象
            List<User> userList = sqlSession.selectList("test.findUserByName", "tao");
            System.out.println(userList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //插入用户信息
    @Test
    public void insertUser() {
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            //得到配置文件流
            InputStream inputStreams = Resources.getResourceAsStream("sqlMapConfig.xml");
            //创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStreams);
            //通过工厂得到SQLSession
            sqlSession = sqlSessionFactory.openSession();
            //通过SQLSession操作数据库
            //第一个参数：映射文件中statement的id，等于namespace+“.”+statement的id
            //第二个参数：指定与映射文件匹配的parameterType类型的参数值
            User user = new User();
            user.setUsername("dbappbyuuid2");
            user.setBirthday(new Date());
            user.setSex(1);
            user.setAddress("浙江省杭州市滨江区");
            //sqlSession.insert("test.insertUser",user);//自增主键
            sqlSession.insert("test.insertUserUUID", user);//uuid主键
            //提交事务
            sqlSession.commit();
            //获取新增主键
            //System.out.println(user.getId());
            System.out.println(user.getUuid().length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //删除用户
    @Test
    public void deleteUser() {
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            //得到配置文件流
            InputStream inputStreams = Resources.getResourceAsStream("sqlMapConfig.xml");
            //创建会话工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStreams);
            //通过工厂得到SQLSession
            sqlSession = sessionFactory.openSession();
            //通过SQLSession操作数据库
            //第一个参数：映射文件中statement的id，等于namespace+“.”+statement的id
            //第二个参数：指定与映射文件匹配的parameterType类型的参数值
            sqlSession.delete("test.deleteUser",14);
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //更新用户
    @Test
    public void updateUser(){
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlSession = null;
        try {
            //得到配置文件流
            InputStream inputStreams = Resources.getResourceAsStream("sqlMapConfig.xml");
            //创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStreams);
            //通过工厂得到SQLSession
            sqlSession = sqlSessionFactory.openSession();
            //通过SQLSession操作数据库
            //第一个参数：映射文件中statement的id，等于namespace+“.”+statement的id
            //第二个参数：指定与映射文件匹配的parameterType类型的参数值
            User user = new User();
            user.setId(13);
            user.setUsername("dbappupdate1");
            user.setBirthday(null);
            sqlSession.update("test.updateUser",user);
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
