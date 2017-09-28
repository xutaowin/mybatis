package com.dbapp.mybatis.pojo;

import java.util.Date;
import java.util.List;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/6/1
 * @Time： 20:32
 */
public class Orders {
    private Integer id;
    private Integer userId;
    private String number;
    private Date createTime;
    private String note;

    //用户信息
    private User user;
    //订单明细
    private List<OrderDetail> orderDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
