package beanFactory;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author micro soft
 * @date 2019/7/5 23:32
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("使用静态工厂方法注入bean");
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean-factory.xml");
        Car car =(Car) ctx.getBean("car");
        System.out.println(car);

        System.out.println("使用实例工厂方法注入bean");
        Car car2=(Car) ctx.getBean("car2");
        System.out.println(car2);

    }
}
