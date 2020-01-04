package com.majun.mybatis.traditionDao;

import com.majun.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImp implements UserDao{

    private SqlSession sqlSession;

    public UserDaoImp(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void addUser(User user) {
        sqlSession.insert("insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findUser(Integer id) {
        User user = sqlSession.selectOne("getUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        sqlSession.delete("deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
    }
}
