package com.kill.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//声明为切面类
@Aspect
@Component
public class SpringbootAop {


    //

    /**
     * 设置切点 配置为理论:  修饰符 返回值类型 报名.类名.方法名[set* ](参数)异常
     *
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
     * 修饰符匹配（modifier-pattern?）
     * 返回值匹配（ret-type-pattern）可以为*表示任何返回值,全路径的类名等
     * 类路径匹配（declaring-type-pattern?）
     * 方法名匹配（name-pattern）可以指定方法名 或者 *代表所有, set* 代表以set开头的所有方法
     * 参数匹配（(param-pattern)）可以指定具体的参数类型，多个参数间用“,”隔开，各个参数也可以用“*”来表示匹配任意类型的参数，如(String)表示匹配一个String参数的方法；(*,String) 表示匹配有两个参数的方法，第一个参数可以是任意类型，而第二个参数是String类型；可以用(..)表示零个或多个任意参数
     * 异常类型匹配（throws-pattern?）
     * 其中后面跟着“?”的是可选项
     *
     *
     */
    @Pointcut(value = "execution(* com.kill.service.impl..aaa(..))")
    public void aop(){
    }

    @Before("aop()")
    public void before(){
        System.out.println("before：执行方法前");
    }


    @After("aop()")
    public void after(){
        System.out.println("after：执行方法后");
    }


    @AfterThrowing("aop()")
    public void afterThrowing(){
        System.out.println("afterThrowing：异常抛出后");
    }

    @AfterReturning("aop()")
    public void afterReturning(){
        System.out.println("afterReturning：方法返回后");
    }

    //  around的优先级比before高
    @Around("aop()")
    public void around(ProceedingJoinPoint joinPoint){

        System.out.println("around：环绕通知前");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around：环绕通知后");

    }

}