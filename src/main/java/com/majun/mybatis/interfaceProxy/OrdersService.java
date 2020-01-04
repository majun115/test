package com.majun.mybatis.interfaceProxy;

import com.majun.mybatis.pojo.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Orders订单表操作
 */
public class OrdersService {
    SqlSessionFactoryBuilder builder;
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    /**
     * 通过builder来获取sqlSession
     */
    @Before
    public void init() throws IOException {
        builder = new SqlSessionFactoryBuilder();
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    /**
     * 查询所有orders订单表中的信息
     */
    @Test
    public void getOrdersList(){
        //通过sqlSession获取代理对象
        OrdersMapperInterfaceProxy mapper = sqlSession.getMapper(OrdersMapperInterfaceProxy.class);
        //通过代理对象来执行sql语句
        List<Orders> ordersList = mapper.getOrdersList();
        for (Orders orders:ordersList) {
            System.out.println(orders);
        }
    }

}
