package com.lwstudy.springcore.xml;

import com.lwstudy.springcore.instance.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 15:50
 */
public class XmlShapeApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-context.xml");

//        XmlShapeCompute shapeCompute = (XmlShapeCompute) context.getBean("shapeCompute");
//        Shape shape = shapeCompute.computeShape("triangle");
//        System.out.println(shape);

//        ClientService clientService = (ClientService) context.getBean("clientService");
//        System.out.println(clientService.getServiceDate());
//        System.out.println(clientService.hashCode());
//        ClientService clientService1 = (ClientService) context.getBean("clientService");
//        System.out.println(clientService1.hashCode());
        ClientService clientService = (ClientService) context.getBean("clientService");
        System.out.println(clientService.hashCode());

        ClientService clientService2 = (ClientService) context.getBean("clientService2");
        System.out.println(clientService2.hashCode());
    }
}
