package beanCollection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author micro soft
 * @version id: Main, v 0.1 2019/7/1 16:44 micro soft Exp$
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("bean-collection.xml");
        // 第一个人：测试集合属性
        System.out.println("第一个人：测试集合属性");
        Person person5=(Person) applicationContext.getBean("person5");
        System.out.println(person5);


        // 第二个人：测试map集合
        System.out.println("第二个人：测试map集合");
        NewPerson person6=(NewPerson) applicationContext.getBean("person6");
        System.out.println(person6);

        // 配置数据源：测试prop集合
        System.out.println("配置数据源：测试prop集合");
        Datasource properties = (Datasource) applicationContext.getBean("dataSource");
        System.out.println(properties);

        // 第三个人：测试外部集合
        System.out.println("第三个人：测试外部集合");
        Person person7= (Person) applicationContext.getBean("person7");
        System.out.println(person7);

        // 第四个人：使用p命名空间
        System.out.println("第四个人：使用p命名空间");
        Person person8=(Person)applicationContext.getBean("person8");
        System.out.println(person8);

        applicationContext.close();

    }
}
