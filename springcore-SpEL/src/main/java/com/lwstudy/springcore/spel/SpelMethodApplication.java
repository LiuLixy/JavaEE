package com.lwstudy.springcore.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 17:37
 * @Description SpEL方法解析
 */
public class SpelMethodApplication {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        // String 对象的方法
        String strSubstring = parser.parseExpression(
                "'HelloWorld'.substring(5)").getValue(String.class);
        System.out.println(strSubstring);

        Integer strLength = parser.parseExpression(
                "'HelloWorld'.length()").getValue(Integer.class);
        System.out.println(strLength);

        Integer strIndexOf = parser.parseExpression(
                "'HelloWorld'.indexOf('World')").getValue(Integer.class);
        System.out.println(strIndexOf);

        // JavaSE 中使用反射调用方法
        try {
            String obj = "HelloWorld";
            Method method = null;
            method = obj.getClass().getMethod("length");
            Object value = method.invoke(obj);
            System.out.println(value);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // 静态方法
        // java.lang.System.currentTimeMillis()   当前时间戳
        long currentTimes = parser.parseExpression(
                "T(java.lang.System).currentTimeMillis()").getValue(long.class);
        System.out.println(currentTimes);

        // java.lang.Math.min();
        double minVal = parser.parseExpression(
                "T(java.lang.Math).min(10, 20)").getValue(double.class);
        System.out.println(minVal);

        // 实例方法
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        EvaluationContext context = new StandardEvaluationContext(simpleDateFormat);
        // String date = simpleDateFormat.format(new java.util.Date());
        String dateFormat = parser.parseExpression(
                "format(new java.util.Date())").getValue(context, String.class);
        System.out.println(dateFormat);
    }
}
