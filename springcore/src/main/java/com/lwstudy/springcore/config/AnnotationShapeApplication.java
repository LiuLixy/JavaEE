package com.lwstudy.springcore.config;

import com.lwstudy.springcore.common.Shape;
import com.lwstudy.springcore.common.impl.Circular;
import com.lwstudy.springcore.common.impl.Rectangle;
import com.lwstudy.springcore.common.impl.Triangle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 16:46
 */
@Configuration
@ComponentScan(basePackages = "com.lwstudy.springcore")
public class AnnotationShapeApplication {

    @Bean(name = "circular")
    public Shape circular() {
        return new Circular(30);
    }

    @Bean(name = "rectangle")
    public Shape rectangle() {
        return new Rectangle(10, 20);
    }

    @Bean(name = "triangle")
    public Shape triangle() {
        return new Triangle(3, 4, 5);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationShapeApplication.class);
        AnnotationShapeCompute annotationShapeCompute =
                context.getBean(AnnotationShapeCompute.class);
        Shape shape = annotationShapeCompute.computeShape("rectangle");
        System.out.println(shape);
    }
}
