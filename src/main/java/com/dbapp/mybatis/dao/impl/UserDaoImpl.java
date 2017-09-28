package com.dbapp.mybatis.dao.impl;

import com.dbapp.mybatis.dao.UserDao;
import com.dbapp.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.Date;

/**
 * @desc:和spring整合的用户管理Dao
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 18:35
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    /**
     * SqlSession sqlSession 不要定义成类成员变量，因为里面有操作数据库方法和数据属性
     * 即为线程不安全的，所以要定义成局部变量
     * @param id
     * @return
     */
    public User findUserById(int id) {
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("test.findUserById", 1);
        return user;
    }

    public void insertUser(User user) {
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.insert("test.insertUser",user);
    }

    public void deleteUser(int id) {
        SqlSession sqlSession = this.getSqlSession();
        sqlSession.delete("test.deleteUser",id);
    }
}
