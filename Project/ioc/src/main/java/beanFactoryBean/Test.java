package beanFactoryBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author micro soft
 * @date 2019/7/6 10:36
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("使用factoryBean注入bean");
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean-factoryBean.xml");
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
    }
}
