package com.lwstudy.springcore.aop.impl.aspect;

import com.lwstudy.springcore.aop.PayService;
import org.springframework.stereotype.Service;

/**
 * @Author: LiuWang
 * @Created: 2018/8/24 9:52
 */
@Service
public class AlipayService implements PayService {

    @Override
    public void pay() {

        // 1. 安全检查

        // 2. 日志记录

        // 3-A. 支付开始时间

        // Alipay-核心支付逻辑，扣钱

        // 3-B. 支付结束时间
        System.out.println("AlipayService");
//        throw new RuntimeException("Exception");
    }
}
