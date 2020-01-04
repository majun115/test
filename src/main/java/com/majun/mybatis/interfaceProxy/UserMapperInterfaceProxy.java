package com.majun.mybatis.interfaceProxy;

import com.majun.mybatis.pojo.QueryVo;
import com.majun.mybatis.pojo.User;

import java.util.List;

public interface UserMapperInterfaceProxy {
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
    /**
     * 查询多条数据，并对User进行封装
     */
    List<User> getUserList(QueryVo queryVo);
    /**
     * 获取用户总数
     */
    int getuserTotal();
    /**
     * 动态sql查询用户
     */
    List<User> queryUserList(QueryVo queryVo);
    /**
     *动态sql查询多个id的用户信息
     */
    List<User> queryUserIds(QueryVo queryVo);
}
