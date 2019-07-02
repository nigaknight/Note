package beanAnnotation;

import beanAnnotation.component.TestObject;
import beanAnnotation.controller.UserController;
import beanAnnotation.repository.UserRepository;
import beanAnnotation.repository.UserRepositoryImpl;
import beanAnnotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 通过component注解配置的bean
        System.out.println("通过component注解配置的bean");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-annotation.xml");
        TestObject testObject= (TestObject) applicationContext.getBean("testObject");
        System.out.println(testObject);
        // 通过repository注解配置的bean
        System.out.println("通过repository注解配置的bean");
        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
        System.out.println(userRepository);
        // 通过controller注解配置的bean
        System.out.println("通过controller注解配置的bean");
        UserController userController=(UserController) applicationContext.getBean("userController");
        System.out.println(userController);
        // 通过service注解配置的bean
        System.out.println("通过service注解配置的bean");
        UserService userService=(UserService) applicationContext.getBean("userService");
        System.out.println(userService);
    }
}
