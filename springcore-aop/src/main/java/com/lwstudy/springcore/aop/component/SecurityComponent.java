package com.lwstudy.springcore.aop.component;

import org.springframework.stereotype.Component;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 9:59
 */
@Component
public class SecurityComponent {

    // 安全检查

    public void security() {
        System.out.println("SecurityComponent");
    }

}
