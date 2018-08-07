package com.lwstudy.springcore.spel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 18:52
 * @Description  SpEL基于注解的配置
 */
@Data
@Component
public class SystemEnvironmentBean {

    @Value(value = "#{systemEnvironment['Path']}")
    private String path;

    @Value(value = "#{systemEnvironment['SystemDrive']}")
    private String systemDrive;

    @Value(value = "#{systemEnvironment['APPDATA']}")
    private String appData;
}
