package com.lwstudy.springcore.aop.component;

import org.springframework.stereotype.Component;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 9:58
 */
@Component
public class LogComponent {
    // 日志记录

    public void log() {
        System.out.println("LogComponent");
    }
}
