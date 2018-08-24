package com.lwstudy.springcore.aop.impl.cglibproxy;

import com.lwstudy.springcore.aop.component.LogComponent;
import com.lwstudy.springcore.aop.component.SecurityComponent;
import com.lwstudy.springcore.aop.component.TimeComponent;
import com.lwstudy.springcore.aop.PayService;
import com.lwstudy.springcore.aop.impl.AlipayService;
import com.lwstudy.springcore.aop.impl.BankService;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 11:37
 *
 * 被代理的类可以不实现任何接口
 *
 */
public class CglibProxy {

    /**
     * 实现了接口
     */
    public static void implementsInterface() {
        PayService target = new AlipayService();

        // method interceptor == invocation handler
        PayServiceCglibProxy interceptor = new PayServiceCglibProxy(
                target, new SecurityComponent(),
                new LogComponent(), new TimeComponent()
        );

        // proxy object
        PayService payService = (PayService) Enhancer.create(target.getClass(), interceptor);
        payService.pay();
    }

    /**
     * 没有实现接口
     */
    public static void noImplementsInterface() {
        BankService target = new BankService();

        // method interceptor == invocation handler
        PayServiceCglibProxy interceptor = new PayServiceCglibProxy(
                target, new SecurityComponent(),
                new LogComponent(), new TimeComponent()
        );

        // proxy object
        BankService payService = (BankService) Enhancer.create(target.getClass(), interceptor);
        payService.pay();
    }

    public static void main(String[] args) {
        noImplementsInterface();
    }
}
