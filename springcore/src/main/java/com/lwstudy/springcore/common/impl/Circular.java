package com.lwstudy.springcore.common.impl;

import com.lwstudy.springcore.common.Shape;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 15:34
 */
public class Circular implements Shape {

    private final double radius;

    public Circular(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double computeArea() {
        return Math.PI*Math.pow(radius, 2);
    }

    public double computeSide() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circular{" +
                "radius=" + radius +
                ", ares=" + this.computeArea() +
                ", side=" + this.computeSide() +
                '}';
    }
}
