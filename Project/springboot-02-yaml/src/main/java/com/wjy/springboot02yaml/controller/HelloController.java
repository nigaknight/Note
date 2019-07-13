package com.wjy.springboot02yaml.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    @author nigaknight
    @since 2019/7/13 22:01    
*/
@RestController
public class HelloController {
    @Value("${person.name}")
    private String name;
    @RequestMapping("/hello")
    public String hello(){
        return "hello"+name;
    }
}
