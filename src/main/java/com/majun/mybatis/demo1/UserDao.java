package com.majun.mybatis.demo1;

import com.majun.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDao {
    SqlSessionFactoryBuilder builder ;
    SqlSessionFactory sqlSessionFactory;
    InputStream resourceAsStream;
    SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        //通过SqlSessionFactoryBuilder 来获取sqlSessionFactory
        builder = new SqlSessionFactoryBuilder();
        //加载SqlMapConfig.xml文件
        resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = builder.build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 根据id查询一个
     * @throws IOException
     */
    @Test
    public void getUserById() throws IOException {
        //通过selectOne来查询我们的一个用户
        //第一个参数，sql语句的id
        //第二个参数，我们sql语句的参数
        User user = sqlSession.selectOne("getUserById", 1);
        System.out.println(user.getUsername());
        sqlSession.close();
        resourceAsStream.close();
    }
    /**
     * 通过地址进行模糊查询
     */
    @Test
    public void getUserByAddress() throws IOException {
        List<User> users = sqlSession.selectList("getUserByAddress", "河南");
        sqlSession.close();
        resourceAsStream.close();
    }
    /**
     * 插入一条数据
     */
    @Test
    public void insertUser() throws IOException {
        //创建user对象
        User user = new User();
        //添加数据
        user.setSex("1");
        user.setAddress("河北石家庄");
        user.setBirthday(new Date());
        user.setUsername("华晨宇");
        sqlSession.insert("insertUser",user);
        System.out.println(user);
        //提交数据
        sqlSession.commit();
        sqlSession.close();
        resourceAsStream.close();
    }
    /**
     * 更新user
     */
    @Test
    public void uodateUser(){
        User user = sqlSession.selectOne("getUserById",28);
        user.setAddress("上海");
        sqlSession.update("updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
