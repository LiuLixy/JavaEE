package com.lwstudy.springcore.aop.impl.aspect;

import org.springframework.stereotype.Component;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 14:58
 */
@Component
public class BankPayService {

    public void pay() {
        System.out.println("无参数...");
    }

    public void pay(String str) {
        System.out.println("有参数...");
    }

}
