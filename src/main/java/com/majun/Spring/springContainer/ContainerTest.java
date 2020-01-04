package com.majun.Spring.springContainer;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContainerTest {
    /**
     * 容器实现方式方式一：通过ClassPathXmlApplicationContext 来获取容器
     */
    @Test
    public void getUserService(){
        //创建spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从spring容器当中获取一个javaBean对象
        UserServiceImp userService = (UserServiceImp)context.getBean("userServiceImp1");
        userService.sayHello();
    }
    /**
     * 容器实现方式方式二：通过FileSystemXmlApplicationContext 来获取容器
     */
    @Test
    public void getFileSystemXmlApplicationContext(){
      //创建spring容器
       ApplicationContext context = new FileSystemXmlApplicationContext("E:\\develop10\\java\\IntelliJ IDEA 2019.2.4\\IdeaProjects\\mybatis\\src\\main\\resources\\applicationContext.xml");
       //从容器中获取javaBean对象
        UserService userService = (UserService) context.getBean("userService");
        userService.sayHello();
    }

}
