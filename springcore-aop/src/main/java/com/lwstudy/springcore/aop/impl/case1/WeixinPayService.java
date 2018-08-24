package com.lwstudy.springcore.aop.impl.case1;

import com.lwstudy.springcore.aop.component.LogComponent;
import com.lwstudy.springcore.aop.component.SecurityComponent;
import com.lwstudy.springcore.aop.component.TimeComponent;
import com.lwstudy.springcore.aop.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 9:53
 */
@Service(value = "weixinPayService1")
public class WeixinPayService implements PayService {

    @Autowired
    private LogComponent logComponent;
    @Autowired
    private SecurityComponent securityComponent;
    @Autowired
    private TimeComponent timeComponent;

    @Override
    public void pay() {

        // 1. 安全检查
        securityComponent.security();

        // 2. 日志记录
        logComponent.log();

        // 3-A. 支付开始时间
        long start = timeComponent.startTime();

        // Weixin-核心支付逻辑，扣钱

        // 3-B. 支付结束时间
        long end = timeComponent.endTime();

    }
}
