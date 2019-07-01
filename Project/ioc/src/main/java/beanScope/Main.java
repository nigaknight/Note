package beanScope;

import beanAutowire.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wjy
 * @date 2019-07-01-21:33
 */
public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-scope.xml");
        Car car1 = (Car) applicationContext.getBean("car");
        Car car2 = (Car) applicationContext.getBean("car");
        System.out.println(car1==car2);
    }
}
