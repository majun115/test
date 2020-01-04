package com.majun.mybatis.pojo;

import java.util.List;

/**
 * pojo封装类
 */
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public List<Integer> getList() {
        return ids;
    }

    public void setList(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
