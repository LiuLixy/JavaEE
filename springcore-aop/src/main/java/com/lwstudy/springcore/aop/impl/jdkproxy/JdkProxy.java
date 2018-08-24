package com.lwstudy.springcore.aop.impl.jdkproxy;

import com.lwstudy.springcore.aop.PayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 11:03
 */
public class JdkProxy {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        PayServiceJDKInvocationHandler handler =
                (PayServiceJDKInvocationHandler) context.getBean("payServiceJDKInvocationHandler");

        PayService alipayServer = (PayService) context.getBean("alipayService");

        PayService payService = (PayService) Proxy.newProxyInstance(
                alipayServer.getClass().getClassLoader(),
                new Class[] {
                        PayService.class
                },
                handler
        );

        payService.pay();
    }
}
