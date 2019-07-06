package beanGenericDi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author micro soft
 * @date 2019/7/6 11:10
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("泛型依赖注入");
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean-generic-di.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }
}
