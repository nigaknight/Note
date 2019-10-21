package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld=(HelloWorld) context.getBean("helloworld");
        helloWorld.hello();
    }
}
