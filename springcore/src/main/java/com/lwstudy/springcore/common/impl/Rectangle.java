package com.lwstudy.springcore.common.impl;

import com.lwstudy.springcore.common.Shape;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 15:35
 */
public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double computeArea() {
        return width * height;
    }

    public double computeSide() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", ares=" + this.computeArea() +
                ", side=" + this.computeSide() +
                '}';
    }
}
