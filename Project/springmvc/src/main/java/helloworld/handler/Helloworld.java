package helloworld.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nigaknight
 * @since 2019/7/7 17:30
 *
 */

/*
1、使用@RequestMapping注解来映射请求的URL（在前端传过来）
2、返回值会通过视图解析器（在springMVC配置文件中配置）为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下解析：
prefix+returnVal+suffix，然后做转发操作
 */
@Controller
public class Helloworld {
    @RequestMapping("/helloworld")
    public String helloworld(){
        System.out.println("Hello world!");
        return "success";
    }
}
