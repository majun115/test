package com.majun.Spring.transaction.dao;

public interface AccountDao {
    //转出
    void outMoney(String name,double d);
    //转入
    void  inMoney(String name,double d);
}
