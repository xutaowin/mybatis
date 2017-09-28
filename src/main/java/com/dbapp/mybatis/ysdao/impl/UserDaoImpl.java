package com.dbapp.mybatis.ysdao.impl;

import com.dbapp.mybatis.pojo.User;
import com.dbapp.mybatis.ysdao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @desc:原始用户管理Dao
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 18:35
 */
public class UserDaoImpl implements UserDao {
    //原始dao begin
    //需要向dao实现类中注入SqlSessionFactory
    //通过构造函数注入
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    /**
     * SqlSession sqlSession 不要定义成类成员变量，因为里面有操作数据库方法和数据属性
     * 即为线程不安全的，所以要定义成局部变量
     * @param id
     * @return
     */
    public User findUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", 1);
        sqlSession.close();
        return user;
    }

    public List<User> findUserByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserByName", name);
        sqlSession.close();
        return users;
    }

    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser",user);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    public void deleteUser(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
    }
    //原始dao end
}
