package com.wjy.springboot02yaml;

import com.wjy.springboot02yaml.bean.Person;
import com.wjy.springboot02yaml.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02YamlApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    HelloService helloService;

/*    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("helloworld");
        System.out.println(b);
    }*/

    @Test
    public void contextLoads() {
        System.out.println(person);
/*        System.out.println(helloService);
        HelloService helloworld = (HelloService) ioc.getBean("helloworld");
        System.out.println(helloworld);*/
    }

}
