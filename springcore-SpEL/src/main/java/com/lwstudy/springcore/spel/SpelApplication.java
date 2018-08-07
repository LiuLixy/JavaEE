package com.lwstudy.springcore.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 18:31
 */
public class SpelApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-spel.xml");

        for (int i = 0; i < 10; i++) {
            GuessNumber guessNumber = (GuessNumber) context.getBean("guessNumber");
            System.out.println(guessNumber);
        }

        SystemPropertiesBean systemPropertiesBean = (SystemPropertiesBean) context.getBean("systemPropertiesBean");
        System.out.println(systemPropertiesBean);

        SystemEnvironmentBean systemEnvironmentBean = (SystemEnvironmentBean) context.getBean("systemEnvironmentBean");
        System.out.println(systemEnvironmentBean);

        MyDataSource myDataSource = (MyDataSource) context.getBean("myDataSource");
        System.out.println(myDataSource);
    }
}
