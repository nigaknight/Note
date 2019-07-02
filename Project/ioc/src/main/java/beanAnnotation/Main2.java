package beanAnnotation;

import beanAnnotation.controller.UserController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author micro soft
 * @version : Main2, v 0.1 2019/7/2 11:31 micro soft Exp$
 */
public class Main2 {
    public static void main(String[] args) {
        // 通过注解配置bean之间的关系
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-annotation.xml");
        UserController userController = (UserController) applicationContext.getBean("userController");
        userController.execute();
    }
}
