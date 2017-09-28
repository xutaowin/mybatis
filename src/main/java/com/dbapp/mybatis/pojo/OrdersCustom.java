package com.dbapp.mybatis.pojo;

import java.util.Date;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/6/1
 * @Time： 20:36
 */
//通过此类映射订单和用户查询的结果，让此类继承包含字段较多的pojo类
public class OrdersCustom extends Orders{
    //添加用户属性
    private String username;
    private int sex;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
