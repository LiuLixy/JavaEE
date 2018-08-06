package com.lwstudy.springcore.assemble;

/**
 * @Author: LiuWang
 * @Created: 2018/8/6 22:18
 */
public class ExampleBean2 {
    private String email;

    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExampleBean2{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
