package com.dbapp.mybatis.service.impl;

import com.dbapp.mybatis.mapper.UserMapper;
import com.dbapp.mybatis.pojo.Uplog;
import com.dbapp.mybatis.pojo.User;
import com.dbapp.mybatis.pojo.UserCustom;
import com.dbapp.mybatis.pojo.UserQueryVo;
import com.dbapp.mybatis.service.UplogService;
import com.dbapp.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @author: xutao
 */
@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UplogService uplogService;
    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> findUserByName(String name) {
        return null;
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertUser(User user){
        userMapper.insertUser(user);
        Uplog uplog = new Uplog();
        uplog.setProName("test2");
        uplog.setCurVersion("123");
        uplog.setLastVersion("234");
        uplog.setSerialNumber("123456789");
        uplogService.add(uplog);
        /*String s = null;
        s.length();*/
    }

    @Override
    public void insertUserUUID(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> findUserByHashMap(Map paramMap) {
        return null;
    }

    @Override
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) {
        return null;
    }

    @Override
    public int findUserCount(UserQueryVo userQueryVo) {
        return 0;
    }

    @Override
    public User findUserByIdResultMap(int id) {
        return null;
    }
}
