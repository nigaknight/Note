package com.wjy.springboot02yaml;

import com.wjy.springboot02yaml.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02YamlApplicationTests {

    @Autowired
    Person person;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
