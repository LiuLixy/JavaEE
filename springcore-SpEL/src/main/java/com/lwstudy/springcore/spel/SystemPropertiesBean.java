package com.lwstudy.springcore.spel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 18:46
 * @Description  SpEL基于注解的配置
 */
@Data
@Component
public class SystemPropertiesBean {

    @Value(value = "#{systemProperties['java.class.path']}")
    private String classPath;

    @Value(value = "#{systemProperties['java.home']}")
    private String javaHome;

    @Value(value = "#{systemProperties['java.version']}")
    private String javaVersion;

    @Value(value = "#{systemProperties['os.name']}")
    private String osName;

}
