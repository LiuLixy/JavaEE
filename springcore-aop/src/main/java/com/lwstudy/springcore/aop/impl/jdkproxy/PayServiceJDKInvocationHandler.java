package com.lwstudy.springcore.aop.impl.jdkproxy;

import com.lwstudy.springcore.aop.component.LogComponent;
import com.lwstudy.springcore.aop.component.SecurityComponent;
import com.lwstudy.springcore.aop.component.TimeComponent;
import com.lwstudy.springcore.aop.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 10:44
 */
@Component
public class PayServiceJDKInvocationHandler implements InvocationHandler {

    @Autowired
    private LogComponent logComponent;
    @Autowired
    private SecurityComponent securityComponent;
    @Autowired
    private TimeComponent timeComponent;
    @Autowired
    @Qualifier(value = "alipayService")
    private PayService payService;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 1. 安全检查
        securityComponent.security();
        // 2. 日志记录
        logComponent.log();
        // 3-A. 支付开始时间
        timeComponent.startTime();
        // 核心支付逻辑，扣钱
        Object result = method.invoke(payService, args);
        // 3-B. 支付结束时间
        timeComponent.endTime();
        return result;
    }
}
