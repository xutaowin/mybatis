package com.dbapp.mybatis.ysdao;

import com.dbapp.mybatis.pojo.User;

import java.util.List;

/**
 * @desc: 原始用户管理Dao
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 18:34
 */
public interface UserDao {
    //根据id查询用户信息
    User findUserById(int id);
    //根据用户姓名模糊查询用户信息
    List<User> findUserByName(String name);
    //添加用户信息
    void insertUser(User user);
    //删除用户
    void deleteUser(int id);
}
