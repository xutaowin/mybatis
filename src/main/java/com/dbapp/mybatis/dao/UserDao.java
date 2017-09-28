package com.dbapp.mybatis.dao;

import com.dbapp.mybatis.pojo.User;

/**
 * @desc: 和spring整合的用户管理Dao
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 18:34
 */
public interface UserDao {
    //根据id查询用户信息
    User findUserById(int id);
    //添加用户信息
    void insertUser(User user);
    //删除用户
    void deleteUser(int id);
}
