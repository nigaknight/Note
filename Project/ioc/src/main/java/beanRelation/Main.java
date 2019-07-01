package beanRelation;

import beanAutowire.Address;
import beanAutowire.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wjy
 * @date 2019-07-01-21:33
 */
public class Main {
    public static void main(String[] args){
        // 地址：使用bean的继承
        ClassPathXmlApplicationContext applicationContext2=new ClassPathXmlApplicationContext("bean-relation.xml");
        System.out.println("地址：使用bean的继承");
        Address address1= (Address) applicationContext2.getBean("address1");
        Address address2= (Address) applicationContext2.getBean("address2");
        System.out.println(address1);
        System.out.println(address2);

        // 第一个人：测试bean的依赖关系
        System.out.println("第一个人：测试bean的依赖关系");
        Person person3= (Person) applicationContext2.getBean("person");
        System.out.println(person3);
    }
}
