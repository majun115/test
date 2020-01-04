package com.majun.mybatis.traditionDao;

import com.majun.mybatis.pojo.User;

public interface UserDao {
    /**
     * 添加数据
     */
    void addUser(User user);
    /**
     * 更新数据
     */
    void updateUser(User user);
    /**
     * 根据id查询一条数据
     */
    User findUser(Integer id);
    /**
     * 删除一条数据
     */
    void deleteUser(Integer id);


}
