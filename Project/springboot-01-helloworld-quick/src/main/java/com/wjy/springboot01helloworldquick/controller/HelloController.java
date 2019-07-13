package com.wjy.springboot01helloworldquick.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    @author nigaknight
    @since 2019/7/13 20:11    
*/

// @ResponseBody的功能：这个类的所有方法返回的数据直接写给浏览器（如果是对象转为json数据）
/*@Controller
@ResponseBody*/
// @RestController是@Controller和@ResponseBody的组合注解
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick!";
    }
}
