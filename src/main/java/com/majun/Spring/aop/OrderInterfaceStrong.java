package com.majun.Spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强类
 */
@Component
@Aspect
public class OrderInterfaceStrong {
    /**
     * 权限检验
     *
     */
    @Before(value = "execution(* *.add(..))")
    public void checkPrivileg(JoinPoint joinPoint){
        //连接点.获得签名.获得声明的类
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        //连接点.获得签名.获得声明类型
        System.out.println(joinPoint.getSignature().getDeclaringType());
        System.out.println("我是权限校验，在方法执行之前执行");
    }
    /**
     * 后置的增强
     */
    @AfterReturning(value = "execution(* *.delete(..))",returning = "object")
    public  void  afterStrong(JoinPoint joinPoint,Object object){
        System.out.println("我是后置通知，我要在目标方法执行之后进行执行");
        System.out.println("我接受到的方法的返回值是object"+object);
    }
    /**
     * 环绕增强
     * @throws Throwable
     */
    @Around(value = "execution(* *.update(..))")
    public  Object  aroundStrong(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("我是环绕通知，我会在目标方法执行之前执行");
        //执行proceed 方法才会真正的执行我们的目标类当中的方法
        Object proceed = joinPoint.proceed();
        System.out.println("我是环绕通知，我会在目标方法执行之后执行");
        return proceed;
    }
    /**
     * 异常抛出通知
     */
    @AfterThrowing(value = "execution(* *.find(..))",throwing = "throwable")
    public  void  exceptStrong(Throwable throwable){
        System.out.println("我是异常抛出通知，只有在目标方法抛出异常的时候我，我才会执行");
        System.out.println(throwable.toString());
    }
    /**
     * 最终通知
     */
    @After(value = "execution(* *.batch(..))")
    public  void finalStrong(JoinPoint joinPoint){
        System.out.println("我是最终通知，无论如何我都会执行，就算目标方法抛错，我也要执行");
    }


}
