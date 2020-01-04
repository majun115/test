package com.majun.mybatis.traditionDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserService {
    SqlSessionFactoryBuilder builder;
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    /**
     * 获得sqlSession
     */
    @Before
    public void init() throws IOException {
        builder = new SqlSessionFactoryBuilder();
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    /**
     * 删除数据
     */
    @Test
    public void deleteUser(){
        UserDaoImp user = new UserDaoImp(sqlSession);
        user.deleteUser(28);
    }
}
