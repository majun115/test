package com.majun.mybatis.connectQuery;

import com.majun.mybatis.pojo.User;

import java.util.List;

/**
 * User用户表，一对一，一对多
 */
public interface UserMapperInterface {
    /**
     * 一对多查询，查询用户有几个订单
     */
    List<User> queryUserListJoinOrders();
}
