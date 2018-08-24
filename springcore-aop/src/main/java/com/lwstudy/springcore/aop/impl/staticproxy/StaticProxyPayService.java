package com.lwstudy.springcore.aop.impl.staticproxy;

import com.lwstudy.springcore.aop.component.LogComponent;
import com.lwstudy.springcore.aop.component.SecurityComponent;
import com.lwstudy.springcore.aop.component.TimeComponent;
import com.lwstudy.springcore.aop.PayService;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 12:11
 */
public class StaticProxyPayService implements PayService {

    private final PayService target;
    private final SecurityComponent securityComponent;
    private final LogComponent logComponent;
    private final TimeComponent timeComponent;


    public StaticProxyPayService(PayService target, SecurityComponent securityComponent,
                                 LogComponent logComponent, TimeComponent timeComponent) {
        this.target = target;
        this.securityComponent = securityComponent;
        this.logComponent = logComponent;
        this.timeComponent = timeComponent;
    }

    @Override
    public void pay() {
        securityComponent.security();
        logComponent.log();
        timeComponent.startTime();
        target.pay();
        timeComponent.endTime();
    }
}
