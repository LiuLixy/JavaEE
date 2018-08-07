package com.lwstudy.springcore.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 16:29
 * @Description  SpEL文本字符解析
 */
public class SpelTextApplication {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        String result = (String) parser.parseExpression("'Hello World'").getValue();
        System.out.println(result);

        String result2 = parser.parseExpression("'Hello World'").getValue(String.class);
        System.out.println(result2);

        Integer intValue = parser.parseExpression("120").getValue(Integer.class);
        System.out.println(intValue);

        boolean boolValue = parser.parseExpression("false").getValue(Boolean.class);
        System.out.println(boolValue);
    }
}
