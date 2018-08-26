package com.lwstudy.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 10:46
 */
public class DataSourceApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println(dataSource.getClass().getCanonicalName());
    }

}
