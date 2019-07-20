package com.wjy.springboot04restfulcurd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/*
    @author nigaknight
    @since 2019/7/14 20:59    
*/
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        return "success";
    }
}
