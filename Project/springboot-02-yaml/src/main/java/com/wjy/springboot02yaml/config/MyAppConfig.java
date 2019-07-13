package com.wjy.springboot02yaml.config;

import com.wjy.springboot02yaml.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    @author nigaknight
    @since 2019/7/13 23:44
    @Configuration： 指明当前类是一个配置类，就是来替代之前的spring配置文件
*/
@Configuration
public class MyAppConfig {

    // 将方法中的返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloworld(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}
