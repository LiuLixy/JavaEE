package com.lwstudy.springcore.common.impl;

import com.lwstudy.springcore.common.Shape;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 15:35
 */
public class Triangle implements Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double computeArea() {
        double p = (a + b + c) / 2;
        double s = Math.sqrt((p - a) * (p - b) * (p - c) * p);
        return s;
    }

    public double computeSide() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", ares=" + this.computeArea() +
                ", side=" + this.computeSide() +
                '}';
    }
}
