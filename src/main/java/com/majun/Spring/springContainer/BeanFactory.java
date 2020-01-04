package com.majun.Spring.springContainer;

/**
 * BeanFactory，bean静态工厂类
 */
public class BeanFactory {
    //静态方法
    public static UserServiceImp getUser(){
        return new UserServiceImp();
    }
    //实例党发
    public UserServiceImp getUser1(){
        return new UserServiceImp();
    }
}
