package com.lwstudy.springcore.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 17:12
 * @Description SpEL数组和集合解析
 */
public class SpelCollectionApplication {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        // array
        int[] intArray = parser.parseExpression("new int[] {1, 2, 3}").getValue(int[].class);
        System.out.println(Arrays.toString(intArray));

        String[] strArray = parser.parseExpression(
                "new String[]{'Hello', 'World'}").getValue(String[].class);
        System.out.println(Arrays.toString(strArray));

        String[] strArray2 = parser.parseExpression(
                "new String[]{\"Hello\", \"World\"}").getValue(String[].class);
        System.out.println(Arrays.toString(strArray2));

        // List
        List listIntVal = parser.parseExpression("{1, 2, 3, 4}").getValue(List.class);
        System.out.println(listIntVal);

        List listObjectVal = parser.parseExpression("{\"Java\", \"Spring\"}").getValue(List.class);
        System.out.println(listObjectVal);

        // map {key:value, key:value}
        Map mapVal = parser.parseExpression("{username:'zhangsan', age:22}").getValue(Map.class);
        System.out.println(mapVal);

        Map mapVal2 = parser.parseExpression("{username:'zhangsan', age:22, " +
                "placeOfBirth:{nation:'China', district:'XiAn'}}").getValue(Map.class);
        System.out.println(mapVal2);
        System.out.println(mapVal2.get("username"));
        System.out.println(mapVal2.get("placeOfBirth"));
    }
}
