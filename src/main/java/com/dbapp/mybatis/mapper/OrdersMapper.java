package com.dbapp.mybatis.mapper;

import com.dbapp.mybatis.pojo.Orders;
import com.dbapp.mybatis.pojo.OrdersCustom;
import com.dbapp.mybatis.pojo.User;

import java.util.List;

/**
 * Created by XUTAO on 2016/11/30.
 * 用户管理mapper接口 相当于dao接口
 */
public interface OrdersMapper {
    //查询订单关联查询用户使用resultType
    List<OrdersCustom> findOrdersUser() throws Exception;
    //查询订单管理查询用户使用ResultMap
    List<Orders> findOrdersUserResultMap() throws Exception;
    //查询订单关联查询用户及订单明细 使用resultMap
    List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
    //查询用户及购买的商品信息 使用resultMap
    List<User> findUserAndItemsResultMap() throws Exception;
    //查询订单关联查询用户，用户信息我们需要延迟加载
    List<Orders> findOrdersUserLazyLoading() throws Exception;
}
