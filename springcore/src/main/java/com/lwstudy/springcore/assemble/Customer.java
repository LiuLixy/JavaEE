package com.lwstudy.springcore.assemble;

/**
 * @Author: LiuWang
 * @Created: 2018/8/18 20:35
 */
public class Customer {

    private final Bar bar;

    public Customer(Bar bar) {
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "bar=" + bar +
                '}';
    }
}
