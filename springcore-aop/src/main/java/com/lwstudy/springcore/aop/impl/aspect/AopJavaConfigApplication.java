package com.lwstudy.springcore.aop.impl.aspect;

import com.lwstudy.springcore.aop.PayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 15:12
 */
@Configuration
@ComponentScan(basePackages = "com.lwstudy.springcore.aop.impl.aspect")
@EnableAspectJAutoProxy
public class AopJavaConfigApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopJavaConfigApplication.class);

        PayService payService = (PayService) context.getBean("alipayService");
        payService.pay();
    }

}
