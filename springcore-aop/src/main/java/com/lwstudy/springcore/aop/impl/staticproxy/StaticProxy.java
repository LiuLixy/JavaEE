package com.lwstudy.springcore.aop.impl.staticproxy;

import com.lwstudy.springcore.aop.component.LogComponent;
import com.lwstudy.springcore.aop.component.SecurityComponent;
import com.lwstudy.springcore.aop.component.TimeComponent;
import com.lwstudy.springcore.aop.impl.AlipayService;
import com.lwstudy.springcore.aop.impl.WeixinPayService;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 12:13
 */
public class StaticProxy {

    public static void main(String[] args) {
        StaticProxyPayService staticProxy = new StaticProxyPayService(
                new WeixinPayService(),
                new SecurityComponent(),
                new LogComponent(),
                new TimeComponent()
        );
        staticProxy.pay();
        System.out.println("---------------------------");
        StaticProxyPayService staticProxy2 = new StaticProxyPayService(
                new AlipayService(),
                new SecurityComponent(),
                new LogComponent(),
                new TimeComponent()
        );
        staticProxy2.pay();
    }

}
