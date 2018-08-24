package com.lwstudy.springcore.aop.impl.aspect;

import com.lwstudy.springcore.aop.PayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 15:22
 */
public class AopXmlApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-aop2.xml");
        PayService payService = (PayService) context.getBean("weixinPayService");
        payService.pay();
    }



}
