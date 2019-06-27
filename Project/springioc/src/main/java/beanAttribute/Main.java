package beanAttribute;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*给bean的属性赋值
* Car类具有brand、corp、price和maxSpeed四个属性
* Person类具有name、age、car三个属性
* Person的bean引用了Car的bean*/

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 第一辆车
        Car car=(Car) applicationContext.getBean("car1");
        System.out.println(car);
        // 第二辆车
        car=(Car) applicationContext.getBean("car2");
        System.out.println(car);
        // 第一个人：测试引用外部已声明的bean
        Person person=(Person) applicationContext.getBean("person");
        System.out.println(person);
        // 第二个人：测试内部bean
        Person person2=(Person) applicationContext.getBean("person2");
        System.out.println(person2);
        applicationContext.close();
    }
}
