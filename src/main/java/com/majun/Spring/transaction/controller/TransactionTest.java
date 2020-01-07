package com.majun.Spring.transaction.controller;

import com.majun.Spring.transaction.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransactionTest {
    @Autowired
    public AccountService accountService;
    @Test
    public void  transferMoney(){

        //获取容器
       // accountService = (AccountService) context.getBean("accountSevice");
        //调用转账方法
        accountService.transferMoney("陈瑶","李沁",1000);
    }
}
