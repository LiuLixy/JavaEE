package com.lwstudy.springcore.xml;

import com.lwstudy.springcore.common.Shape;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 15:50
 */


public class XmlShapeCompute {
    private Shape circular;
    private Shape rectangle;
    private Shape triangle;

    public Shape computeShape(String shapeName) {
        if (shapeName == null || shapeName.length() == 0) {
            throw new IllegalArgumentException("Not found" + shapeName);
        }
        if (shapeName.equals("circular")) {
            return circular;
        }
        if (shapeName.equals("rectangle")) {
            return rectangle;
        }
        if (shapeName.equals("triangle")) {
            return triangle;
        } else {
            throw new IllegalArgumentException("Not found" + shapeName);
        }
    }

    public void setCircular(Shape circular) {
        this.circular = circular;
    }

    public void setRectangle(Shape rectangle) {
        this.rectangle = rectangle;
    }

    public void setTriangle(Shape triangle) {
        this.triangle = triangle;
    }

    @Override
    public String toString() {
        return "XmlShapeCompute{" +
                "circular=" + circular +
                ", rectangle=" + rectangle +
                ", triangle=" + triangle +
                '}';
    }
}
