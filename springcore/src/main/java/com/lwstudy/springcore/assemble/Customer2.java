package com.lwstudy.springcore.assemble;

/**
 * @Author: LiuWang
 * @Created: 2018/8/18 20:35
 */
public class Customer2 {

    private Bar bar;

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "bar=" + bar +
                '}';
    }
}
