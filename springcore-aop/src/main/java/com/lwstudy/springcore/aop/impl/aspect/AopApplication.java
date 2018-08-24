package com.lwstudy.springcore.aop.impl.aspect;

import com.lwstudy.springcore.aop.PayService;
import com.lwstudy.springcore.aop.impl.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 14:40
 */
public class AopApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-aop.xml");

//        PayService payService = (PayService) context.getBean("alipayService");
//        payService.pay();

        BankPayService bankPayService = context.getBean(BankPayService.class);
        bankPayService.pay();
        System.out.println("-----------------------------");
        bankPayService.pay("haha");
    }

}
