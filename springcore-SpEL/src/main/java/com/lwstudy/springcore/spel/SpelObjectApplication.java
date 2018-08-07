package com.lwstudy.springcore.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 16:43
 * @Description  SpEL对象属性解析
 */
public class SpelObjectApplication {

    public static void main(String[] args) {

        // 创建 User 对象
        User user = new User();
        user.setUserName("zhangsan");
        user.setLastDate(new Date());
        user.setCredits(20);
        PlaceOfBirth placeOfBirth = new PlaceOfBirth("中国", "西安");
        user.setPlaceOfBirth(placeOfBirth);

        System.out.println(user);
        System.out.println(user.getPlaceOfBirth());

        // SpEL 访问对象的属性
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        // 访问用户的姓名
        String userName = (String) parser.parseExpression("userName").getValue(context);
        System.out.println("userName: " + userName);

        // 访问用户出生地
        PlaceOfBirth placeOfBirth1 = parser.parseExpression("placeOfBirth").getValue(context, PlaceOfBirth.class);
        System.out.println(placeOfBirth1);

        // 访问出生地中的 nation
        String nation = parser.parseExpression("placeOfBirth.nation").getValue(context, String.class);
        System.out.println("nation: " + nation);

        // 重载方法，不使用上下文
        String nation1 = parser.parseExpression("placeOfBirth.nation").getValue(user, String.class);
        System.out.println("nation: " + nation1);
    }
}
