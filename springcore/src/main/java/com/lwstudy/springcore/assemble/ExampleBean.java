package com.lwstudy.springcore.assemble;

import java.beans.ConstructorProperties;

/**
 * @Author: LiuWang
 * @Created: 2018/8/6 21:02
 */
public class ExampleBean {

    private final int age;
    private final String name;

    public ExampleBean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
