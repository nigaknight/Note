package beanSpel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author micro soft
 * @version : Main, v 0.1 2019/7/1 18:41 micro soft Exp$
 */
public class Main {
    public static void main(String[] args) {
        // 测试用spel为属性赋一个字面值
        System.out.println("测试用spel为属性赋一个字面值");
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-spel.xml");
        Address address = (Address) applicationContext.getBean("address");
        System.out.println(address);

        // 使用spel调用静态方法
        System.out.println("使用spel调用静态方法");
        Car car= (Car) applicationContext.getBean("car");
        System.out.println(car);

        // 使用spel引用其他的bean、bean的属性；在spel中使用运算符
        System.out.println("使用spel引用其他的bean、bean的属性；在spel中使用运算符");
        Person person=(Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
