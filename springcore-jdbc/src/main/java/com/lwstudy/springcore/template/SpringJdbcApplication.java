package com.lwstudy.springcore.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 13:02
 */
public class SpringJdbcApplication {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        JdbcTemplateOperation jdbcTemplateOperation = context.getBean(JdbcTemplateOperation.class);

//        jdbcTemplateOperation.addBook();
//        jdbcTemplateOperation.queryBook();
//        jdbcTemplateOperation.updateBook();
//        jdbcTemplateOperation.queryBook();
//        jdbcTemplateOperation.deleteBook();
//        jdbcTemplateOperation.queryBook();

        jdbcTemplateOperation.queryBookForList();
        jdbcTemplateOperation.countBook();

    }
}
