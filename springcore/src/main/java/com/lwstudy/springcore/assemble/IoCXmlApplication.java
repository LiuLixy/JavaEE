package com.lwstudy.springcore.assemble;

import com.lwstudy.springcore.xml.XmlShapeCompute;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @Author: LiuWang
 * @Created: 2018/8/6 21:04
 */
public class IoCXmlApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-context-bean-instance-demo.xml");
        // Bean 的引用
        Foo foo = (Foo) context.getBean("foo");
        System.out.println(foo);

        // 根据参数类型
        Foo foo1 = (Foo) context.getBean("foo1");
        System.out.println(foo1);

        // 根据参数类型
        ExampleBean exampleBean = (ExampleBean) context.getBean("exampleBean");
        System.out.println(exampleBean);

        // 根据参数位置
        ExampleBean exampleBean2 = (ExampleBean) context.getBean("exampleBean2");
        System.out.println(exampleBean2);

        // 根据参数名称
        ExampleBean exampleBean3 = (ExampleBean) context.getBean("exampleBean3");
        System.out.println(exampleBean3);

        // Setter 方法装配
        XmlShapeCompute shapeCompute = (XmlShapeCompute) context.getBean("xmlShapeCompute");
        System.out.println(shapeCompute);

        // 直接赋值
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);

        // idref
        IdRefExample idRefExample = (IdRefExample) context.getBean("idRefExample");
        System.out.println(idRefExample);

        // 内部 Bean
        XmlShapeCompute xmlShapeCompute = (XmlShapeCompute) context.getBean("xmlShapeCompute2");
        System.out.println(xmlShapeCompute);

        // Collection
        ComplexObject complexObject = (ComplexObject) context.getBean("complexObject");
        System.out.println(complexObject);

        // null 和 空字符串
        ExampleBean2 exampleBean22 = (ExampleBean2) context.getBean("exampleBean22");
        // 需要调试才能看出结果
        System.out.println(exampleBean22);

        // 需要 Debug 执行才能看出延迟初始化
        LazyExampleBean lazyExampleBean = (LazyExampleBean) context.getBean("lazyExampleBean");
        System.out.println(lazyExampleBean);

        // 自动装配
        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer);

        Customer2 customer2 = (Customer2) context.getBean("customer2");
        System.out.println(customer2);

        Customer2 customer3 = (Customer2) context.getBean("customer3");
        System.out.println(customer3);
    }
}
