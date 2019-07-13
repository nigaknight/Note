package com.wjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    @author nigaknight
    @since 2019/7/13 16:49    
*/
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //通过静态方法run将Spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
