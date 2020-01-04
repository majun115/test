package com.majun.mybatis.interfaceProxy;

import com.majun.mybatis.pojo.QueryVo;
import com.majun.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {
    SqlSessionFactoryBuilder builder;
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        builder = new SqlSessionFactoryBuilder();
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    /**
     * 插入一条数据
     */
    @Test
    public void insertUser(){
        //接口代理跟反射
        UserMapperInterfaceProxy mapper = sqlSession.getMapper(UserMapperInterfaceProxy.class);
        User user = new User();
        user.setAddress("北京");
        user.setUsername("刘幸");
        user.setBirthday(new Date());
        user.setSex("2");
        mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     * 根据地址进行模糊查询
     */
    @Test
    public void getUserList(){
        //通过sqlSession获取代理对象
        UserMapperInterfaceProxy mapper = sqlSession.getMapper(UserMapperInterfaceProxy.class);
        //获取User的封装类
        QueryVo queryVo = new QueryVo();
        //创建user对象
        User user = new User();
        user.setAddress("北京");
        user.setBirthday(new  Date());
        user.setUsername("张三");
        queryVo.setUser(user);
        //通过代理对象mapper来调用方法执行sql语句
        List<User> userList = mapper.getUserList(queryVo);
        for (User u: userList ) {
            System.out.println(u.getId()+"-"+u.getUsername());
        }
        sqlSession.close();
    }
    /**
     * 获取用户的总数
     */
    @Test
    public void getUserTotal(){
        //通过sqlSession来过去代理对象
        UserMapperInterfaceProxy mapper = sqlSession.getMapper(UserMapperInterfaceProxy.class);
        int i = mapper.getuserTotal();
        System.out.println(i);
        sqlSession.close();
    }
    /**
     * 动态sql查询用户,通过id或者address
     */
    @Test
    public void queryUserList(){
        //通过sqlsession来获取代理对象
        UserMapperInterfaceProxy mapper = sqlSession.getMapper(UserMapperInterfaceProxy.class);
        QueryVo queryVo = new QueryVo();
        User user1 = new User();
       // user1.setId(30);
        user1.setAddress("北京");
        queryVo.setUser(user1);
        //通过mapper来执行sql语句
        List<User> users = mapper.queryUserList(queryVo);
        for (User user:users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    /**
     * 通过动态sql查询用户，多个id查询
     */
    @Test
    public void queryUserIds(){
        //通过sqlsession来获取代理对象
        UserMapperInterfaceProxy mapper = sqlSession.getMapper(UserMapperInterfaceProxy.class);
        QueryVo queryVo = new QueryVo();
        //向创建的集合中添加数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(30);
        ids.add(31);
        ids.add(32);
        queryVo.setList(ids);
        List<User> users = mapper.queryUserIds(queryVo);
        for (User u:users
             ) {
            System.out.println(u);
        }
        sqlSession.close();
    }
}
