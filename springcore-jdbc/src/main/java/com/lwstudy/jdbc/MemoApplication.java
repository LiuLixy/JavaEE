package com.lwstudy.jdbc;

import com.lwstudy.jdbc.entity.MemoGroup;
import com.lwstudy.jdbc.service.MemoGroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 15:56
 */
public class MemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        MemoGroupService memoGroupService = (MemoGroupService) context.getBean("memoGroupService");

        List<MemoGroup> memoGroupList = memoGroupService.queryMemoGroup(1);
        System.out.println(memoGroupList);
    }
}
