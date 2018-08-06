package com.lwstudy.springcore.assemble;

/**
 * @Author: LiuWang
 * @Created: 2018/8/6 21:43
 */
public class IdRefExample {
    private final String barId;

    public IdRefExample(String barId) {
        this.barId = barId;
    }

    @Override
    public String toString() {
        return "IdRefExample{" +
                "barId='" + barId + '\'' +
                '}';
    }
}
