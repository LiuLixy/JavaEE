package com.lwstudy.springcore.aop.impl.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @Author: LiuWang
 * @Created: 2018/8/24 14:09
 */
// @Aspect
@Component
public class PayServiceAspect {

    @Pointcut(value = "execution(* com.lwstudy.springcore.aop.*.pay())")
    public void payPointCut() {

    }

    /**
     * 表示参数中有一个为 String
     */
    @Pointcut(value = "args(java.lang.String)")
    public void stringArgs() {

    }

    @Before(value = "stringArgs()")
    public void beforeString() {
        System.out.println("Method has a parameter");
    }

    /**
     * 时间、地点
     */
    @Before(value = "payPointCut()")
    public void beforeLog() {
        // 工作
        System.out.println("> before log");
    }

    @Before(value = "payPointCut()")
    public void beforeSecurity() {
        System.out.println(">> before security");
    }

    @Before(value = "payPointCut()")
    public void beforeStartTime() {
        System.out.println(">>> before start time");
    }

    @After(value = "payPointCut()")
    public void afterEndTime() {
        System.out.println(">>> after end time");
    }

    @Around(value = "payPointCut()")
    public Object aroundTime(ProceedingJoinPoint joinPoint) {
        // 前面的切面代码
        System.out.println(">>>> around before");
        Object result = null;
        // 连接点方法的执行
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable.getMessage());
        }
        // 后面的切面代码
        System.out.println(">>>> around after");
        return result;
    }

    @AfterReturning(value = "payPointCut()")
    public void afterReturning() {
        System.out.println(">>>>>> after returning");
    }

    @AfterThrowing(value = "payPointCut()", throwing = "e")
    public void throwing(RuntimeException e) {
        System.out.println(">>>>>> after throwing " + e.getMessage());
    }
}
