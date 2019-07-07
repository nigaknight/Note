# SpringMVC 概述 

## SpringMVC 概述 

1、Spring 为展现层提供的基于 MVC 设计理念的优秀的 Web 框架， 是目前最主流的MVC 框架之一 。

2、Spring3.0 后全面超越 Struts2， 成为最优秀的 MVC 框架。 

3、Spring MVC 通过一套 MVC 注解， 让 POJO 成为处理请求的控制器， 而无须实现任何接口。 

4、支持 REST 风格的 URL 请求。 

5、采用了松散耦合可插拔组件结构， 比其他 MVC 框架更具扩展性和灵活性。 

## SpringMVC 是什么 

一种轻量级的、 基于 MVC 的 Web 层应用框架。 偏前端而不是基于业务逻辑层。 Spring框架的一个后续产品。 

## SpringMVC 能干什么 

1、天生与 Spring 框架集成， 如： (IOC,AOP) 

2、支持 Restful 风格 

3、进行更简洁的 Web 层开发 

4、支持灵活的 URL 到页面控制器的映射 

5、非常容易与其他视图技术集成， 如:Velocity、 FreeMarker 等等 

6、因为模型数据不存放在特定的 API 里， 而是放在一个 Model 里(Map 数据结构实现，因此很容易被其他框架使用) 

7、非常灵活的数据验证、 格式化和数据绑定机制、 能使用任何对象进行数据绑定，不必实现特定框架的 API

8、更加简单、 强大的异常处理 

9、对静态资源的支持 

10、支持灵活的本地化、 主题等解析 

## SpringMVC 怎么玩 

1、将 Web 层进行了职责解耦， 基于请求-响应模型 

2、常用主要组件 

（1）DispatcherServlet： 前端控制器 

（2）Controller： 处理器/页面控制器， 做的是 MVC 中的 C 的事情， 但控制逻辑转移到前端控制器了， 用于对请求进行处理 

（3）HandlerMapping ： 请求映射到处理器， 找谁来处理， 如果映射成功返回一个HandlerExecutionChain 对象（包含一个 Handler 处理器(页面控制器)对象、 多个 HandlerInterceptor 拦截器对象） 

（4）View Resolver : 视图解析器， 找谁来处理返回的页面。 把逻辑视图解析为具体的 View,进行这种策略模式， 很容易更换其他视图技术； 

（5）LocalResolver： 本地化、 国际化 

（6）MultipartResolver： 文件上传解析器 

（7）HandlerExceptionResolver： 异常处理器 

## 永远的 HelloWorld 

1、新建 Web 工程， 加入 jar 包 （可以使用maven导入jar包）

直接导入spring-webmvc的依赖，就可以自动将所需的所有jar包导入进来，包括spring所需的jar包

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.1.5.RELEASE</version>
</dependency>
```

2、在 web.xml 中配置 DispatcherServlet 

通过contextConfigLocation属性指定 Spring MVC 的配置文件的位置。

```xml
    <!--配置DispatcherServlet-->
    <servlet>
        <servlet-name>springDispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--配置的一个初始化参数：配置SpringMVC配置文件(springmvc.xml)的位置和名称-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>springDispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

3、加入 Spring MVC 的配置文件： springmvc.xml 

（1）增加名称空间  mvc

（2）增加配置 

设置扫描组件的包。

配置映射解析器： 如何将控制器返回的结果字符串， 转换为一个物理的视图文件 。

```xml
    <!--配置自动扫描的包：扫描handlers-->
    <context:component-scan base-package="helloworld.handler"></context:component-scan>

    <!--配置视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
```

4、需要创建一个入口页面， index.jsp 

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="helloworld">Hello world</a>
  </body>
</html>
```

5、编写处理请求的处理器， 并标识为处理器 

@Controller注解的类，在Spring MVC的配置文件中被扫描。

```java
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
```

6、编写视图 

web/WEB-INF/views/success.jsp

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Success!</h4>
</body>
</html>
```

7、部署测试 

在Idea中的部署：

（1）配置Tomcat Server：设置启动URL

（2）Add Framework Support：添加web框架（这一步应该在创建工程后就做了，可以自动生成web.xml的骨架）；web文件夹应该有一个小蓝点标识，如果移动了web文件夹，应该在Project Structure中进行相关修改。

8、启动结果

点击Hello World超链接，显示success！画面。

## HelloWorld 深度解析 

1、HelloWorld 请求流程图解 

2、一般请求的映射路径名称和处理请求的方法名称最好一致（实质上方法名称任意） 

3、演示一个错误 

经常有同学会出现配置上错误， 把“/WEB-INF/views/” 配置成了 "/WEB-INF/views" 

4、处理请求方式有哪几种 

5、@RequestMapping 可以应用在什么地方 

6、流程分析 

（1）客户端请求提交到 DispatcherServlet 

（2）由 DispatcherServlet 控制器查询一个或多个 HandlerMapping， 找到处理请求的 Controller 

（3）DispatcherServlet 将请求提交到 Controller（也称为 Handler） 

（4）Controller 调用业务逻辑处理后， 返回 ModelAndView 

（5）DispatcherServlet 查询一个或多个 ViewResoler 视图解析器， 找到 ModelAndView 指定的视图

（6）视图负责将结果显示到客户端  

# @RequestMapping 注解 

## @RequestMapping 映射请求注解 

### @RequestMapping 概念 

1、SpringMVC 使用@RequestMapping 注解为控制器指定可以处理哪些 URL 请求 

2、在控制器的类定义及方法定义处都可标注 @RequestMapping 

（1）标记在类上： 提供初步的请求映射信息。 相对于 WEB 应用的根目录 

（2）标记在方法上： 提供进一步的细分映射信息。 相对于标记在类上的 URL。 

3、若类上未标注 @RequestMapping， 则方法处标记的 URL 相对于 WEB 应用的根目录

4、作用： DispatcherServlet 截获请求后， 就通过控制器上 @RequestMapping 提供的映射信息确定请求所对应的处理方法。  

### @ RequestMapping 源码参考 

## RequestMapping 可标注的位置 

类或方法上；

## RequestMapping 映射请求方式 

### 标准的 HTTP 请求报头 

请求方法-请求URL-HTTP协议及版本

报文头

报文体

### 映射请求参数、 请求方法或请求头 

1、@RequestMapping 除了可以使用请求 URL 映射请求外， 还可以使用请求方法、 请求参数及请求头映射请求 

2、@RequestMapping 的 value【重点】、 method【重点】、 params【了解】 及 heads【了解】 分别表示请求 URL、 请求方法、 请求参数及请求头的映射条件， 他们之间是与的关系， 联合使用多个条件可让请求映射更加精确化。 

3、params 和 headers 支持简单的表达式

（1）param1: 表示请求必须包含名为 param1 的请求参数 

（2）!param1: 表示请求不能包含名为 param1 的请求参数 

（3）param1 != value1: 表示请求包含名为 param1 的请求参数， 但其值不能为 value1 

（4）{"param1=value1", "param2"}: 请求必须包含名为 param1 和 param2 的两个请求参数， 且 param1 参数的值必须为 value1 

## RequestMapping 映射请求参数&请求头 

## RequestMapping 支持 Ant 路径风格 

1、Ant 风格资源地址支持 3 种匹配符

 （1）?： 匹配文件名中的一个字符 ；

（2）*： 匹配文件名中的任意字符 

（3）`**： **` 匹配多层路径 

2、@RequestMapping 还支持 Ant 风格的 UR 

## RequestMapping 映射请求占位符 PathVariable 注解 

1、带占位符的 URL 是 Spring3.0 新增的功能， 该功能在 SpringMVC 向 REST 目标挺进发展过程中具有里程碑的意义 

2、通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中 ：URL 中的 {xxx} 占位符可以通过 @PathVariable("xxx") 绑定到操作方法的入参中。 

请求链接

```xml
<!-- 测试 @PathVariable -->
<a href="springmvc/testPathVariable/1">testPathVariable</a>
```

控制器方法

```java
//@PathVariable 注解可以将请求 URL 路径中的请求参数， 传递到处理请求方法的入参中
@RequestMapping(value="/testPathVariable/{id}")
public String testPathVariable(@PathVariable("id") Integer id){
	System.out.println("testPathVariable...id="+id);
	return "success";
}
```

# REST 

## REST 是什么 

1、REST： 即 Representational State Transfer。（资源） 表现层状态转化。 是目前最流行的一种互联网软件架构。 它结构清晰、 符合标准、 易于理解、 扩展方便， 所以正得到越来越多网站的采用 

（1）资源（Resources）： 网络上的一个实体， 或者说是网络上的一个具体信息。 

它可以是一段文本、 一张图片、 一首歌曲、 一种服务， 总之就是一个具体的存在。可以用一个 URI（统一资源定位符） 指向它， 每种资源对应一个特定的 URI 。获取这个资源， 访问它的 URI 就可以， 因此 URI 即为每一个资源的独一无二的识别符。 

（2）表现层（Representation）： 把资源具体呈现出来的形式， 叫做它的表现层（Representation）。 比如， 文本可以用 txt 格式表现， 也可以用 HTML 格式、 XML格式、 JSON 格式表现， 甚至可以采用二进制格式。 

（3）状态转化（State Transfer）： 每发出一个请求， 就代表了客户端和服务器的一次交互过程。 HTTP 协议， 是一个无状态协议， 即所有的状态都保存在服务器端。 因此， 如果客户端想要操作服务器， 必须通过某种手段， 让服务器端发生“状态转化”（State Transfer） 

（4）具体说， 就是 HTTP 协议里面， 四个表示操作方式的动词： GET、 POST、 PUT、 DELETE。它们分别对应四种基本操作： GET 用来获取资源， POST 用来新建资源， PUT 用来更新资源， DELETE 用来删除资源。 

2、URL 风格 

（1）/order/1 HTTP GET ：得到 id = 1 的 order 

（2）/order/1 HTTP DELETE：删除 id = 1 的 order 

（3）/order HTTP PUT：更新 order 

（4）/order HTTP POST：新增 order 

3、HiddenHttpMethodFilter 

浏览器 form 表单只支持 GET 与 POST 请求， 而 DELETE、 PUT 等 method 并不支持， Spring3.0 添加了一个过滤器， 可以将这些请求转换为标准的 http 方法， 使得支持 GET、 POST、 PUT 与 DELETE 请求。 

## HiddenHttpMethodFilter 过滤器源码分析 

# 处理请求数据 

## 请求处理方法签名 

1、Spring MVC 通过分析处理方法的签名， HTTP 请求信息绑定到处理方法的相应入参中。 

2、Spring MVC 对控制器处理方法签名的限制是很宽松的， 几乎可以按喜欢的任何方式对方法进行签名 

3、必要时可以对方法及方法入参标注相应的注解（ @PathVariable 、 @RequestParam、@RequestHeader 等）

4、Spring MVC 框架会将 HTTP 请求的信息绑定到相应的方法入参中， 并根据方法的返回
值类型做出相应的后续处理 

## @RequestParam 注解 

1、在处理方法入参处使用 @RequestParam 可以把请求参数传递给请求方法 

（1）value： 参数名 

（2）required： 是否必须。 默认为 true, 表示请求参数中必须包含对应的参数， 若不存在， 将抛出异常 

（3）defaultValue: 默认值， 当没有传递参数时使用该值 

链接

```xml
<!--测试 请求参数 @RequestParam 注解使用 -->
<a href="springmvc/testRequestParam?username=atguigu&age=10">testRequestParam</a>
```

控制器方法

```java
/**
* @RequestParam 注解用于映射请求参数
* value 用于映射请求参数名称
* required 用于设置请求参数是否必须的
* defaultValue 设置默认值， 当没有传递参数时使用该值
*/
@RequestMapping(value="/testRequestParam")
public String testRequestParam(
@RequestParam(value="username") String username,
@RequestParam(value="age",required=false,defaultValue="0") int age){
	System.out.println("testRequestParam - username="+username +",age="+age);
	return "success";
}
```

## @RequestHeader 注解 

1、使用 @RequestHeader 绑定请求报头的属性值 

2、请求头包含了若干个属性， 服务器可据此获知客户端的信息， 通过 @RequestHeader 即可将请求头中的属性值绑定到处理方法的入参中 

## @CookieValue 注解 

1、使用 @CookieValue 绑定请求中的 Cookie 值 

2、@CookieValue 可让处理方法入参绑定某个 Cookie 值 

## 使用 POJO 作为参数 

1、使用 POJO 对象绑定请求参数值 

2、Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配，自动为该对象填充属性值。支持级联属性。 如： dept.deptId、 dept.address.tel 等 

## 使用 Servlet 原生 API 作为参数 

MVC 的 Handler 方法可以接受哪些 ServletAPI 类型的参数 

# 处理响应数据 

## SpringMVC 输出模型数据概述 

1、ModelAndView: 处理方法返回值类型为 ModelAndView 时, 方法体即可通过该对象添加模型数据 

2、Map 及 Model: 入参为 org.springframework.ui.Model、org.springframework.ui.ModelMap 或 java.uti.Map 时， 处理方法返回时， Map 中的数据会自动添加到模型中 

3、@SessionAttributes: 将模型中的某个属性暂存到 HttpSession 中， 以便多个请求之间可以共享这个属性 

4、@ModelAttribute: 方法入参标注该注解后, 入参的对象就会放到数据模型中 

## 处理模型数据之 ModelAndView 

1、控制器处理方法的返回值如果为 ModelAndView, 则其既包含视图信息， 也包含模型数据信息。 

2、添加模型数据 

```java
ModelAndView addObject(String attributeName, Object attributeValue)
ModelAndView addAllObject(Map<String, ?> modelMap)
```

3、设置视图 

```java
void setView(View view)
void setViewName(String viewName)
```

4、示例代码

控制器方法

```java
/**
* 目标方法的返回类型可以是 ModelAndView 类型
* 其中包含视图信息和模型数据信息
*/
@RequestMapping("/testModelAndView")
public ModelAndView testModelAndView(){
	System.out.println("testModelAndView");
	String viewName = "success";
	ModelAndView mv = new ModelAndView(viewName );
	mv.addObject("time",new Date().toString()); //实质上存放到 request 域中
	return mv;
}
```

页面链接 

```xml
<!--测试 ModelAndView 作为处理返回结果 -->
<a href="springmvc/testModelAndView">testModelAndView</a>
```

增加成功页面， 显示数据 

```
time: ${requestScope.time }
```

## 处理模型数据之 Map 

1、Spring MVC 在内部使用了一个 org.springframework.ui.Model 接口存储模型数据具体使用步骤 

2、Spring MVC 在调用方法前会创建一个隐含的模型对象作为模型数据的存储容器。 

3、如果方法的入参为 Map 或 Model 类型， Spring MVC 会将隐含模型的引用传递给这些入参

4、在方法体内， 开发者可以通过这个入参对象访问到模型中的所有数据， 也可以向模型中添加新的属性数据  

5、示例代码

控制器方法

```java
//目标方法的返回类型也可以是一个 Map 类型参数（也可以是 Model,或 ModelMap 类型）
@RequestMapping("/testMap")
public String testMap(Map<String,Object> map){ //【重点】
	System.out.println(map.getClass().getName());
	//org.springframework.validation.support.BindingAwareModelMap
	map.put("names", Arrays.asList("Tom","Jerry","Kite"));
	return "success";
}
```

页面链接

```xml
<!-- 测试 Map 作为处理返回结果 -->
<a href="springmvc/testMap">testMap</a>
```

增加成功界面，添加数据

```
names: ${requestScope.names }
```

## 处理模型数据之 SessionAttributes 注解 

1、若希望在多个请求之间共用某个模型属性数据， 则可以在控制器类上标注一个@SessionAttributes, Spring MVC 将在模型中对应的属性暂存到 HttpSession 中。 

2、@SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外， 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中 

## @ModelAttribute 注解 

# 视图解析 

## SpringMVC 如何解析视图概述 

不论控制器返回一个 String,ModelAndView,View 都会转换为 ModelAndView 对象， 由视图解析器解析视图， 然后， 进行页面的跳转。 

## 视图和视图解析器 

1、请求处理方法执行完成后， 最终返回一个 ModelAndView 对象。 对于那些返回 String，View 或 ModeMap 等类型的处理方法， Spring MVC 也会在内部将它们装配成一个ModelAndView 对象， 它包含了逻辑名和模型对象的视图 

2、Spring MVC 借助视图解析器（ViewResolver） 得到最终的视图对象（View）， 最终的视图可以是 JSP ， 也可能是 Excel、 JFreeChart 等各种表现形式的视图 

3、对于最终究竟采取何种视图对象对模型数据进行渲染， 处理器并不关心， 处理器工作重点聚焦在生产模型数据的工作上， 从而实现 MVC 的充分解耦 

## 视图 

1、视图的作用是渲染模型数据， 将模型里的数据以某种形式呈现给客户 

2、为了实现视图模型和具体实现技术的解耦， Spring 在 org.springframework.web.servlet包中定义了一个高度抽象的 View 接口 

3、视图对象由视图解析器负责实例化。 由于视图是无状态的， 所以他们不会有线程安全的问题 

## 常用的视图实现类 

## JstlView 

1、若项目中使用了 JSTL，则 SpringMVC 会自动把视图由 InternalResourceView转为 JstlView（断点调试， 将 JSTL 的 jar 包增加到项目中， 视图解析器会自动修改为 JstlView） 

2、若使用 JSTL 的 fmt 标签则需要在 SpringMVC 的配置文件中配置国际化资源文件 

## 视图解析器 

1、SpringMVC 为逻辑视图名的解析提供了不同的策略， 可以在 Spring WEB 上下文中配置一种或多种解析策略， 并指定他们之间的先后顺序。 每一种映射策略对应一个具体的视图解析器实现类 。

2、视图解析器的作用比较单一： 将逻辑视图解析为一个具体的视图对象。 

3、所有的视图解析器都必须实现 ViewResolver 接口 。

# 处理 JSON 

## 返回 JSON 

1、加入 jar 包 （jackson相关包，可以使用maven导入）

2、编写目标方法， 使其返回 JSON 对应的对象或集合 

```java
@ResponseBody //SpringMVC 对 JSON 的支持
@RequestMapping("/testJSON")
public Collection<Employee> testJSON(){
	return employeeDao.getAll();
}
```

3、增加页面代码： index.jsp 

```html
<a id="testJSON" href="testJSON">testJSON</a>
```

