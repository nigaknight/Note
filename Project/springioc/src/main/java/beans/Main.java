package beans;

import beans.annotation.TestObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-beans.xml");
        TestObject testObject= (TestObject) applicationContext.getBean("testObject");
        System.out.println(testObject);
    }
}
