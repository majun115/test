package com.majun.mybatis.connectQuery;

import com.majun.mybatis.pojo.Orders;
import com.majun.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class connectQueryService {
    SqlSessionFactoryBuilder builder = null;
    InputStream inputStream = null;
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;

    @Before
    public void init() throws IOException {
        builder = new SqlSessionFactoryBuilder();
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    /**
     * 一对一表关联查询，查询订单的用户信息
     */
    @Test
    public void queryOrdersJoinUsers(){
        //通过sqlSession来获取代理对象
        OrdersMapperInterface mapper = sqlSession.getMapper(OrdersMapperInterface.class);
        List<Orders> ordersList = mapper.queryOrdersJoinUsers();
        for (Orders order:ordersList) {
            System.out.println(order+order.getUser().toString());
        }
    }
    /**
     * 一对多查询，查询用户下了几个订单
     */
    @Test
    public void queryUserJoinOrders(){
        //通过sqlSession来获取代理对象
        UserMapperInterface mapper = sqlSession.getMapper(UserMapperInterface.class);
        List<User> users = mapper.queryUserListJoinOrders();
        for (User user:users) {
            System.out.println(user);
            for (Orders order:user.getOrdersList()) {
                System.out.println(order);
            }
        }
    }

}
