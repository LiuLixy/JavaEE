package com.lwstudy.springcore.config;

import com.lwstudy.springcore.common.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author: LiuWang
 * @Created: 2018/7/31 15:50
 */

@Component
public class AnnotationShapeCompute {
    @Autowired
    @Qualifier("circular")
    private Shape circular;

    @Autowired
    @Qualifier("rectangle")
    private Shape rectangle;

    @Autowired
    @Qualifier("triangle")
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
}
