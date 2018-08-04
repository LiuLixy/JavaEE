package com.lwstudy.springcore.instance;

import com.lwstudy.springcore.common.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 17:52
 */
public class InstanceApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-context-bean-instance-demo.xml");

        Shape shape = (Shape) context.getBean("circular");
        System.out.println(shape);

        ClientService clientService = (ClientService) context.getBean("clientService");
        System.out.println(clientService.getServiceDate());

        ClientService clientService2 = (ClientService) context.getBean("clientService2");
        System.out.println(clientService2.getServiceDate());
    }
}
