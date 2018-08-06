package com.lwstudy.springcore.assemble;

/**
 * @Author: LiuWang
 * @Created: 2018/8/6 20:57
 */
public class Foo {
    private final Bar bar;
    private final Baz baz;


    public Foo(Bar bar, Baz baz) {
        this.bar = bar;
        this.baz = baz;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "bar=" + bar +
                ", baz=" + baz +
                '}';
    }
}
