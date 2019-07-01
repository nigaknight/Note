package beanAutowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author micro soft
 * @version : Main, v 0.1 2019/7/1 18:41 micro soft Exp$
 */
public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-autowire.xml");
        // 第一个人：使用按名字自动装配
        System.out.println("第一个人：使用按名字自动装配");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        // 第二个人：使用按类型自动装配
        System.out.println("第二个人：使用按类型自动装配");
        Person person2=(Person) applicationContext.getBean("person2");
        System.out.println(person2);

        applicationContext.close();
    }
}
