package com.lwstudy.springcore.aop.component;

import org.springframework.stereotype.Component;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 9:59
 */
@Component
public class TimeComponent {

    /**
     * 开始时间
     * @return
     */
    public long startTime() {
        System.out.println("TimeComponent-Start");
        return System.currentTimeMillis();
    }
    /**
     * 结束时间
     * @return
     */
    public long endTime() {
        System.out.println("TimeComponent-End");
        return System.currentTimeMillis();
    }

    public long compute(long start, long end) {
        return end - start;
    }

}
