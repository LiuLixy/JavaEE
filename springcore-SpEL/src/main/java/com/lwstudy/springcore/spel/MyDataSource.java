package com.lwstudy.springcore.spel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 19:13
 * @Description  SpEL基于注解的配置
 */
@Data
@Component
public class MyDataSource {

    @Value(value = "#{properties['url']}")
    private String url;

    @Value(value = "#{properties['username']}")
    private String username;

    @Value(value = "#{properties['password']}")
    private String password;

    @Value(value = "#{properties['driverClass']}")
    private String driverClass;

}
