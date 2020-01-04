package com.majun.mybatis.interfaceProxy;

import com.majun.mybatis.pojo.Orders;

import java.util.List;

public interface OrdersMapperInterfaceProxy {
    /**
     * 查询所有的订单信息
     * @return
     */
    List<Orders> getOrdersList();
}
