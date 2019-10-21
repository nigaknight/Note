package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("aopConfig.xml");
        Calculator calculator= (Calculator) context.getBean("calculator");
        int add = calculator.add(1, 4);
        System.out.println(add);
    }
}
