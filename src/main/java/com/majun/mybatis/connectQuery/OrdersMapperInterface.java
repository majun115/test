package com.majun.mybatis.connectQuery;

import com.majun.mybatis.pojo.Orders;

import java.util.List;

/**
 * Orders订单表，一对一
 */
public interface OrdersMapperInterface {
    /**
     * 一对一关联查询
     */
    List<Orders> queryOrdersJoinUsers();
}
