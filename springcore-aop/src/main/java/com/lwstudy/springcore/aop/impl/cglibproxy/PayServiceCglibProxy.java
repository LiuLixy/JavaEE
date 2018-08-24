package com.lwstudy.springcore.aop.impl.cglibproxy;


import com.lwstudy.springcore.aop.component.LogComponent;
import com.lwstudy.springcore.aop.component.SecurityComponent;
import com.lwstudy.springcore.aop.component.TimeComponent;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 11:31
 */
public class PayServiceCglibProxy implements MethodInterceptor {

    private final Object target;
    private final SecurityComponent securityComponent;
    private final LogComponent logComponent;
    private final TimeComponent timeComponent;

    public PayServiceCglibProxy(Object target, SecurityComponent securityComponent,
                                LogComponent logComponent, TimeComponent timeComponent) {
        this.target = target;
        this.securityComponent = securityComponent;
        this.logComponent = logComponent;
        this.timeComponent = timeComponent;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        securityComponent.security();
        logComponent.log();
        Long start = timeComponent.startTime();
        Object result = methodProxy.invoke(target, objects);
        Long end = timeComponent.endTime();
        System.out.println("Cost Time: " + timeComponent.compute(start, end));
        return result;
    }
}
