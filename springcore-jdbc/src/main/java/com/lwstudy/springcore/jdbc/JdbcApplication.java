package com.lwstudy.springcore.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 11:41
 */
public class JdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        JdbcOperation jdbcOperation = context.getBean(JdbcOperation.class);

        jdbcOperation.addBook();

        jdbcOperation.queryBook();

        jdbcOperation.updateBook();

        jdbcOperation.queryBook();
    }

}
