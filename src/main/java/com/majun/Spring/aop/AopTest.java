package com.majun.Spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    /**
     * 通过xml配置的方式实现我们的增强
     */
    @Test
    public void aopXml(){
        //获取Spring容器
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取目标类代理对象
        OrderInterface orderInterface = (OrderInterface) context.getBean("orderInterface");
       // orderInterface.add();
        //orderInterface.delete();
        //orderInterface.update();
       orderInterface.find();
       // orderInterface.batch();

    }
    
}
