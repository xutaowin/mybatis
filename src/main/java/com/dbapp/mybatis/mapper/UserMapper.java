package com.dbapp.mybatis.mapper;

import com.dbapp.mybatis.pojo.User;
import com.dbapp.mybatis.pojo.UserCustom;
import com.dbapp.mybatis.pojo.UserQueryVo;

import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 21:55
 */
public interface UserMapper {
    //根据id查询用户信息
    User findUserById(int id);
    //根据用户姓名模糊查询用户信息
    List<User> findUserByName(String name);
    //添加用户信息
    void insertUser(User user);
    //uuid添加
    void insertUserUUID(User user);
    //删除用户
    void deleteUser(int id);
    //更新用户信息
    void updateUser(User user);
    //根据HashMap查询用户信息
    List<User> findUserByHashMap(Map paramMap);
    //用户信息的综合查询
    List<UserCustom> findUserList(UserQueryVo userQueryVo);
    //用户信息的综合查询总数
    int findUserCount( UserQueryVo userQueryVo);
    //根据id查询用户信息,使用resultMap
    User findUserByIdResultMap(int id);
}
