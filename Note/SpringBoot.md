# SpringBoot 入门

## 概述

1、Spring Boot 是由 Pivotal 团队提供的全新框架， 其设计目的是用来简化新 Spring 应用的初始搭建以及开发过程。 

2、该框架使用了特定的方式来进行配置， 从而使开发人员不再需要定义样板化的配置。 通过这种方式， Spring Boot 致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者 

## 分布式架构 

### 流行分布式架构 

1、Redis：分布式数据库

2、ZooKeeper：分布式的应用程序协调服务

3、Dubbo：阿里巴巴SOA服务化治理方案的核心方案

### Spring 分布式架构 

1、SpringBoot：简化新Spring应用的初始搭建以及开发过程

2、SpringCloud：简化分布式系统基础设施的开发

## 为什么使用SpringBoot

1、Spring 框架由于其繁琐的配置， 一度被人认为“配置地狱” ， 各种 XML、 Annotation 配置混合使用，让人眼花缭乱， 而且如果出错了也很难找出原因 。

2、通过 SpringMVC 框架部署和发布 web 程序， 需要和系统外服务器进行关联， 操作繁琐不方便。 

3、Spring Boot 是由 Spring 官方推出的一个新框架， 对 Spring 进行了高度封装， 是 Spring 未来的发展方向。 使用 Spring Boot 框架后， 可以帮助开发者快速搭建 Spring 框架， 也可以帮助开发者快速启动一个 Web 服务， 无须依赖外部 Servlet 容器， 使编码变得简单， 使配置变得简单， 使部署变得简单， 使监控变得简单。 

## Spring前世今生

### Spring1.x 时代 

1、在 Spring1.x 时代， 都是通过 xml 文件配置 bean 。

2、随着项目的不断扩大， 需要将 xml 配置分放到不同的配置文件中 。

3、需要频繁的在 java 类和 xml 配置文件中切换。 

4、使用基本的框架类及配置文件（.xml） 实现对象的声明及对象关系的整合。 

```
org.springframework.core.io.ClassPathResource
org.springframework.beans.factory.xml.XmlBeanFactory
org.springframework.context.support.ClassPathXmlApplicationContext
```

### Spring2.x 时代 

1、随着 JDK 1.5 带来的注解支持， Spring2.x 可以使用注解对 Bean 进行申明和注入， 大大的减少了 xml配置文件， 同时也大大简化了项目的开发 。

2、那么， 问题来了， 究竟是应该使用 xml 还是注解呢？ 

应用的基本配置用 xml， 比如： 数据源、 资源文件等；

业务开发用注解， 比如： Service 中注入 bean 等。

```
org.springframework.stereotype.@Component
org.springframework.stereotype.@Controller
org.springframework.stereotype.@Service
org.springframework.stereotype.@Repository
org.springframework.stereotype.@Scope
org.springframework.beans.factory.annotation.@Autowired
```

### Spring3.x 到 Spring4.x 

1、从 Spring3.x 开始提供了 Java 配置方式， 使用 Java 配置方式可以更好的理解你配置的 Bean，现在我们就处于这个时代， 并且 Spring4.x 和 Spring boot 都推荐使用 java 配置的方式 。

2、使用更强大的注解完全代替配置文件。 

```
Spring 3.X
使用更强大的注解完全代替配置文件。 
org.springframework.context.annotation.AnnotationConfigApplicationContext
org.springframework.context.annotation.@Configuration
org.springframework.context.annotation.@Bean
org.springframework.context.annotation.@Value
org.springframework.context.annotation.@Import
-------------------------------------------------------------------------------------
Spring 4.X
使用条件注解强化之前版本的注解。
org.springframework.context.annotation.@Conditional
```

### Spring 作者 

1、Rod Johnson 在 2002 年编著的《Expert one on one J2EE design and development》 一书中， 对 Java EE 系统框架臃肿、 低效、 脱离现实的种种现状提出了质疑， 并积极寻求探索革新之道。以此书为指导思想， 他编写了 interface21 框架， 这是一个力图冲破 J2EE 传统开发的困境， 从实际需求出发， 着眼于轻便、 灵巧， 易于开发、 测试和部署的轻量级开发框架。 

2、Spring 框架即以 interface21 框架为基础， 经过重新设计， 并不断丰富其内涵， 于 2004 年 3 月 24 日，
发布了 1.0 正式版。 同年他又推出了一部堪称经典的力作《Expert one-on-one J2EE Development without EJB》 ， 该书在 Java世界掀起了轩然大波， 不断改变着 Java 开发者程序设计和开发的思考方式。 在该书中， 作者根据自己多年丰富的实践经验， 对 EJB 的各种笨重臃肿的结构进行了逐一的分析和否定， 并分别以简洁实用的方式替换之。至此一战功成， Rod Johnson 成为一个改变 Java 世界的大师级人物。 

### 案例 

1、Spring1.x 

```java
public static void main(String[] args) {
    ApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");
    System.out.println("ApplicationContext..."); //立即初始化
    User user = (User)beanFactory.getBean("user");
    System.out.println(user);
}
```

```java
public static void main(String[] args) {
    Resource resource = new ClassPathResource("beans.xml") ;
    XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
    System.out.println("XmlBeanFactory..."); //延迟初始化
    User user = (User)beanFactory.getBean("user");
    System.out.println(user);
}
```

2、Spring2.x 

```
@Controller
@Service
@Repository
@Scope
@Component 
```

3、Spring3.x 

```java
import org.springframework.context.annotation.Bean; //@since 3.0
import org.springframework.context.annotation.Configuration; //@since 3.0
@Configuration
public class BeanConfig {
    @Bean
    public User user() { //方法名称作为 bean 的 id
    return new User();
    }
}
ApplicationContext beanFactory = new AnnotationConfigApplicationContext("com.aguigu");
```

## 创建SpringBoot HelloWorld

一个功能：浏览器发送hello请求，服务器接受请求并处理，响应Hello World字符串；

### 创建 Maven 项目 

在 IDEA中创建 Maven项目

> SSM 基础架构中， 需要生成 web.xml 文件， Spring Boot 框架中无需配置 web.xml 文件。 为什么没有？
> Spring Boot 框架开发 web 系统， 是基于 servlet3.0 或以上规范， 无需 web.xml 文件 

### 集成 Spring Boot 框架 

修改 pom.xml 文件， 增加 Spring Boot 框架的依赖关系及对 Web 环境的支持。

```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```

> 1、以往的项目中， 所有类库的依赖关系都需要我们自己导入到 pom.xml 文件中， 但是 Spring Boot项目增加 spring-boot-starter-web 依赖后，会自动加载 web 环境配置相关依赖(SpringMVC, Tomcat)，简化了我们的操作。 
>
> 2、spring-boot-starter-parent： 继承 Spring Boot 的相关参数 
>
> 3、spring-boot-starter-xxx： 代表一个 Spring Boot 模块 
>
> 4、spring-boot-starter-web： 代表 Web 模块， 在这个模块中包含了许多依赖的 JAR 包 

### 增加程序代码 

1、在 src/main/java 目录中增加类 HelloWorldMainApplication， 并增加相应代码，这个类就是程序的主入口。

```java
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //通过SpringApplication类的静态方法run将Spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
```

2、编写Controller文件（Service文件在这个简单的HelloWorld程序中就不需要添加了）

```java
@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world!";
    }
}
```

3、右键点击项目或项目中的HelloWorldMainApplication类, 选择菜单 Run ， 控制台出现Spring图形表示服务启动成功。

4、访问`http://localhost:8080/hello`，浏览器返回`hello world!`，springboot helloworld项目启动成功。

> 1、Spring Boot 项目中都会有一个以 Application 结尾的应用类，然后有一个标准的 Java入口方法 main
> 方法。 通过这个方法启动 Spring Boot 项目， 方法中无需放入任何业务逻辑。
>
> 2、@SpringBootApplication 注解是 Spring Boot 核心注解 

### 简化部署

```xml
    <!-- 这个插件，可以将应用打包成一个可执行的jar包；-->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

添加这个插件后，执行maven的package命令，将会生成一个在target文件夹下生成一个可执行的jar包；

在cmd下使用java -jar [包名]的命令，可以启动该jar包。效果和在idea中启动相同。

### HelloWorld项目分析

#### 集成了 Tomcat 服务器 

1、将springboot项目打包后的jar包打开，里面有以下文件夹

```
BOOT-INF
 classes 含有我们自己编写的文件
 lib 含有很多依赖的jar包，包括内嵌的tomcat的jar包
META-INF
  maven
org
```

由于项目中依赖有内嵌的tomcat，所以可以直接启动，不需要配置tomcat。

2、当增加 Web 依赖后执行 main 方法， 等同于启动 Tomcat 服务器, 默认端口号为 8080。 

3、如 果 想 要 修 改 默 认 的 Tomcat 服 务 器 端 口 号 ， 可 以 通 过 全 局 配 置 文 件 进 行 配 置 ， 在src/main/resources/目录中增加 application.properties 文件。 

4、Spring Boot 会自动读取 src/main/resources/路径或类路径下/config 路径中的 application.properties
文件或 application.yml 文件。

#### 为什么还会有配置文件 

1、Spring Boot 我们称之为微框架， 这里的“微” 不是小和少的意思， 而是“简” 的意思， 简单， 简洁。项目中大部分的基础配置由 Spring Boot 框架帮我们自动集成， 简化了我们的配置， 但是框架自身为了扩展性， 依然需要提供配置文件 

2、上面的代码中只是简单的应用了 Spring Boot 框架， 但是我们真正要做的是将 Spring Boot 应用到项目中， 所以接下来我们增加对 SpringMVC 框架， Mybatis 框架的集成。 并通过源码的解读对 Spring Boot框架有一个更深层次的理解。

#### POM文件

1、父项目

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
</parent>

他的父项目是
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-dependencies</artifactId>
  <version>1.5.9.RELEASE</version>
  <relativePath>../../spring-boot-dependencies</relativePath>
</parent>
他来真正管理Spring Boot应用里面的所有依赖版本；

```

spring-boot-starter-parent的父项目spring-boot-dependencies是Spring Boot的版本仲裁中心；

以后我们导入依赖默认是不需要写版本；（没有在dependencies里面管理的依赖自然需要声明版本号）

2、启动器

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

spring-boot-starter-web：springboot的web场景启动器；

spring-boot-starter：spring-boot场景启动器；帮我们导入了web模块正常运行所依赖的组件；

Spring Boot将所有的功能场景都抽取出来，做成一个个的starters（启动器），只需要在项目里面引入这些starter相关场景的所有依赖都会导入进来。要用什么功能就导入什么场景的启动器。（所有的场景启动器都可以在springboot官网可以搜到）

#### 主程序类

```java
/**
 *  @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {

        // Spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}

```

1、@SpringBootApplication:    Spring Boot应用标注在某个类上说明这个类是SpringBoot的主配置类，SpringBoot就应该运行这个类的main方法来启动SpringBoot应用；

2、将@SpringBootApplication点开，发现它实际上是一个组合注解，如下所示：

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = {
      @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
      @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {
```

3、@SpringBootConfiguration:Spring Boot的配置类；标注在某个类上，表示这是一个Spring Boot的配置类；

4、将@SpringBootConfiguration点开，它也是一个组合注解：

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration 
```

@Configuration:这是spring的一个底层注解，配置类上需要标注这个注解；配置类相当于spring以前配置时需要用到的配置文件；配置类也是容器中的一个组件；

5、@EnableAutoConfiguration的作用

```
// to do
比较复杂
```

6、Spring Boot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，自动配置类就生效，帮我们进行自动配置工作；以前我们需要自己配置的东西，自动配置类都会帮我们配置；

### Spring Initializer快速创建

使用Spring Initializer快速创建Spring Boot项目。

1、很多IDE（比如IDEA、STS）都支持使用Spring的项目创建向导快速创建一个Spring Boot项目；选择我们需要的模块，向导会联网创建Spring Boot项目；

2、默认生成的Spring Boot项目

（1）主程序已经生成好了，我们只需要实现我们自己的逻辑

```java
@SpringBootApplication
public class Springboot01HelloworldQuickApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01HelloworldQuickApplication.class, args);
    }

}
```

控制层逻辑

```java
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
```

（2）resources文件夹中目录结构

static：保存所有的静态资源； js css  images；

templates：保存所有的模板页面；（Spring Boot默认jar包使用嵌入式的Tomcat，默认不支持JSP页面）；可以使用模板引擎（freemarker、thymeleaf）；

application.properties：Spring Boot应用的配置文件；可以修改一些默认设置；比如修改tomcat端口号：

```properties
server.port=8081
```

这时候就需要用`http://localhost:8081/hello`来访问了。

# SpringBoot配置

## 配置文件

1、SpringBoot使用一个全局的配置文件，配置文件名是固定的；使用application.properties或者application.yml。

2、配置文件的作用：修改SpringBoot自动配置的默认值；SpringBoot在底层都给我们自动配置好；（比如tomcat的端口号）

3、YAML（YAML Ain't Markup Language），以前的配置文件；大多都使用的是  xxxx.xml文件；而YAML是以数据为中心的，比json、xml等更适合做配置文件；

4、配置例子

yaml

```yaml
server:
  port: 8081
```

xml

```xml
<server>
	<port>8081</port>
</server>
```

properties

```properties
server.port=8081
```

## YAML

### 基本语法

1、key:(空格)value；表示一对键值对（空格必须有）；

2、以空格的缩进来控制层级关系；只要是左对齐的一列数据，都是同一个层级的

```yaml
server:
    port: 8081
    path: /hello
```

3、属性和值也是大小写敏感；

### 值的写法

1、字面量

普通的值（数字，字符串，布尔）

（1）字面直接来写；字符串默认不用加上单引号或者双引号；

（2）""：双引号；不会转义字符串里面的特殊字符；特殊字符会作为本身想表示的意思

```
name:   "zhangsan \n lisi"：输出；zhangsan 换行  lisi
```

（3）''：单引号；会转义特殊字符，特殊字符最终只是一个普通的字符串数据

```
name:   ‘zhangsan \n lisi’：输出；zhangsan \n  lisi
```

2、对象、Map

属性和值（键值对）

在下一行来写对象的属性和值的关系；注意缩进；

```yaml
friends:
    lastName: zhangsan
    age: 20
```

行内写法：

```yaml
friends: {lastName: zhangsan,age: 18}
```

3、数组（List、Set）

用- 值表示数组中的一个元素

```yaml
pets:
 - cat
 - dog
 - pig
```

行内写法

```yaml
pets: [cat,dog,pig]
```

## 配置文件值注入

### Yaml配置注入

配置文件

```yaml
person:
    name: dzq
    age: 27
    boss: false
    map: {k1: 1,k2: 15}
    dog:
      name: dog
      age: 12
```

javaBean

```java
/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *      prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能；
 *
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private int age;
    private boolean boss;
    private Map<String,Integer> map;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", map=" + map +
                ", dog=" + dog +
                '}';
    }
}
```

```java
public class Dog {
    private String name;
    private int age;
}
```

我们可以导入配置文件处理器，以后编写配置就有提示了

```xml
<!--导入配置文件处理器，配置文件进行绑定就会有提示-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
```

在springboot的默认测试文件中进行测试

```java
// com.wjy.springboot02yaml.Springboot02YamlApplicationTests

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
```

启动单元测试，输出

```
Person{name='dzq', age=27, boss=false, map={k1=1, k2=15}, dog=Dog{name='dog', age=12}}
```

### Properties配置注入

配置文件

```properties
person.name=邓紫棋
person.age=27
person.boss=false
person.map.k1=1
person.map.k2=12
person.dog.name=玛丽
person.dog.age=12
```

properties配置文件在idea中可能会中文会出现乱码（如以下输出）

```
Person{name='éç´«æ£', age=27, boss=false, map={k1=1, k2=12}, dog=Dog{name='çä¸½', age=12}}
```

在settings/file encodings中修改encoding for properties file为utf-8，并勾上transparent native-to-ascii conversion；然后将乱码的properties文件中的中文重新输入；

```
Person{name='邓紫棋', age=27, boss=false, map={k1=1, k2=12}, dog=Dog{name='玛丽', age=12}}
```

就不出现乱码了（还是yaml比较方便）

### @Value获取配置

对比@ConfigurationProperties

|                      | @ConfigurationProperties | @Value     |
| -------------------- | ------------------------ | ---------- |
| 功能                 | 批量注入配置文件中的属性 | 一个个指定 |
| 松散绑定（松散语法） | 支持                     | 不支持     |
| SpEL                 | 不支持                   | 支持       |
| JSR303数据校验       | 支持                     | 不支持     |
| 复杂类型封装         | 支持                     | 不支持     |

1、@Value需要一个个指定，且支持SpEL

```java
@Component
// @ConfigurationProperties(prefix = "person")
public class Person {
    @Value("${person.name}")
    private String name;
    // SpEL，@ConfigureationProperties不支持
    @Value("#{11*2}")
    private int age;
    @Value(("true"))
    private boolean boss;
    private Map<String,Integer> map;
    private Dog dog;
}
```

测试输出

```
Person{name='邓紫棋', age=22, boss=true, map=null, dog=null}
```

2、松散绑定

比如javabean中的lastName属性，在yaml文件中配置为last-name=zhangsan，那么使用@ConfigureationProperties注解是可以注入进来的；而使用@Value("${person.lastName}")则会出错，必须是@Value("${person.last-name}")

3、数据校验

```java
@Component
@ConfigurationProperties(prefix = "person")
// 数据校验的注解
@Validated
public class Person {
    // @Value("${person.name}")
    // 这个注解的意思是下面的值必须填充邮箱格式
    @Email
    private String name;
    // @Value("#{11*2}")
    private int age;
    // @Value(("true"))
    private boolean boss;
    private Map<String,Integer> map;
    private Dog dog;
}    
```

启动单元测试后会报错，输出异常信息如下

```
    Property: person.name
    Value: 邓紫棋
    Origin: class path resource [application.properties]:1:13
    Reason: 不是一个合法的电子邮件地址
```

4、复杂类型封装

@Value不支持map等类型的值的注入

```java
    @Value("${person.map}")
    private Map<String,Integer> map;
```

启动单元测试后会报错

5、如何选用@Value和@ConfigureationProperties

（1）如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；

创建一个controller层，返回的字符串包含一个配置中的属性值person.name，就可以用@Value注入进来

```java
@RestController
public class HelloController {
    @Value("${person.name}")
    private String name;
    @RequestMapping("/hello")
    public String hello(){
        return "hello"+name;
    }
}
```

启动项目，浏览器访问结果如下

```
hello邓紫棋
```

（2）如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使@ConfigurationProperties；

### @PropertySource获取配置

1、如果所有的配置都写在全局配置文件application.properties中，可读性比较差，所以可以将配置文件分开，使用@PropertySource获取配置。

创建一个配置文件person.properties

```
person.name=周杰伦
person.age=27
person.boss=false
person.map.k1=1
person.map.k2=12
person.dog.name=杰克
person.dog.age=12
```

2、添加@PropertySource获取配置

必须和@ConfigurationProperties一起使用

```java
@ConfigurationProperties(prefix = "person")
@PropertySource(value = "classpath:person.properties")
public class Person {
```

启动单元测试后输出

```
Person{name='周杰伦', age=27, boss=false, map={k1=1, k2=12}, dog=Dog{name='杰克', age=12}}
```

### @ImportResource导入xml配置

1、导入Spring的配置文件（比如配置bean的xml文件），让配置文件里面的内容生效；

2、Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；想让Spring的配置文件生效，加载进来，需要将@ImportResource标注在一个配置类上

3、在springboot中使用配置文件

javabean

```java
public class HelloService {
}
```

xml配置

```xml
<bean id="helloworld" class="com.wjy.springboot02yaml.service.HelloService"></bean>
```

单元测试

```java
    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("helloworld");
        System.out.println(b);
    }
```

输出

```
false
```

说明我们配置的bean没有起作用，ioc容器中没有helloworld这个bean。

4、添加@ImportResource注解

在主程序中添加@ImportResource注解，将配置文件导入进来

```java
@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class Springboot02YamlApplication {
```

再启动单元测试，输出

```
true
```

使用xml文件配置bean不常用，一般用全注解。

### 全注解添加组件

1、SpringBoot推荐给容器中添加组件的方式：推荐使用全注解的方式；

2、配置类@Configuration相当于Spring配置文件

```java
@Configuration
public class MyAppConfig {

    // 将方法中的返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloworld(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}
```

3、启动单元测试，输出

```
配置类@Bean给容器中添加组件了...
true
```

### 配置文件占位符

1、随机数

```
${random.value}、${random.int}、${random.long}
${random.int(10)}、${random.int[1024,65536]}
```

2、配置文件占位符的使用

占位符获取之前配置的值，如果没有可以是用来指定默认值

```properties
person.name=邓紫棋${random.uuid}
person.age=${random.int}
person.boss=false
person.map.k1=1
person.map.k2=12
person.dog.name=${person.name}_${person.hello}玛丽
person.dog.age=12
```

输出

```
Person{name='邓紫棋8304b094-5501-4eb6-a15c-ff8365c9c45a', age=-576686214, boss=false, map={k1=1, k2=12}, dog=Dog{name='邓紫棋c28eeb6e-6762-40fe-8c05-b8d1876af299_${person.hello}玛丽', age=12}}
```

如果person确实有hello这个属性，那么如果这个属性之前没有赋值，引用${person.hello}将会出错；如果person没有这个属性，那么就直接表示为${person.hello}

## Profile切换环境

### 多Profile文件

1、默认使用主配置文件application.properties的配置；

2、我们在配置文件编写的时候，文件名可以是   application-{profile}.properties/yml，其中profile可以任意

3、在主配置文件中指定  spring.profiles.active={profile}

```
application.properties 定义server.port=8080
application-dev.properties 定义server.port=8081
application-prod.properties 定义server.port=8082
```

启动主程序后，使用主配置文件，端口号为8080。

4、指定其他配置文件生效

```properties
server.port=8080
spring.profiles.active=dev
```

启动主程序后，使用application-dev.properties，端口号为8081

### yml多文档块方式

不用分多个配置文件，直接使用---将文件分成多个文档块，每个文档块可以进行单独的配置定义，并在第一个文档块中定义要激活的配置。

```yaml

server:
  port: 8081
spring:
  profiles:
    active: prod

---
server:
  port: 8083
spring:
  profiles: dev


---

server:
  port: 8084
spring:
  profiles: prod  #指定属于哪个环境
```

### 其他环境激活方式

1、命令行指定

（1）在Run Configurations里面的Program arguments中添加命令行 --spring.profiles.active=dev；就可以将配置环境切换到dev环境；

（2）对于工程打成的jar包，java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev；可以直接在测试的时候，配置传入命令行参数。

2、虚拟机参数

在Run Configurations里面的Program arguments中添加指令 -Dspring.profiles.active=dev

## 配置文件加载位置

1、springboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件

- –file:./config/（当前文件根目录）
- –file:./
- –classpath:/config/ （resources目录下-classpath）
- –classpath:/

2、优先级由高到底，高优先级的配置会覆盖低优先级的配置；

3、SpringBoot会从这四个位置全部加载主配置文件，形成互补配置；即多个配置文件都有的配置用高优先级，高优先级的没有的配置用低优先级。

4、我们还可以通过spring.config.location来改变默认的配置文件位置

项目打包好以后，我们可以使用命令行参数的形式，启动项目的时候来指定配置文件的新位置；指定配置文件和默认加载的这些配置文件共同起作用形成互补配置；

java -jar spring-boot-02-config-02-0.0.1-SNAPSHOT.jar --spring.config.location=G:/application.properties

（此时G盘有一个application.properties配置文件）

通过这种方式，在项目已经打包完成以后，运维可以根据需要自己编写一个配置文件，增加所需要的配置；

## 外部配置加载顺序

## 自动配置原理

# SpringBoot日志

## 日志框架

1、 小张需要开发一个大型系统

（1）代码里包含有很多System.out.println("")，来将关键数据打印在控制台；应该将这些打印去掉？还是写在一个文件里面？

（2）框架来记录系统的一些运行时信息；日志框架 ；  zhanglogging.jar；

（3）高大上的几个功能？异步模式？自动归档？xxxx？  zhanglogging-good.jar？

（4）将以前框架卸下来？换上新的框架，重新修改之前相关的API；zhanglogging-prefect.jar；

（5）JDBC---数据库驱动；写了一个统一的接口层，即日志门面（日志的一个抽象层）；logging-abstract.jar；

之后我们只要给项目中导入具体的日志实现就行了；我们之前的日志框架都是实现的抽象层；

2、市面上的日志框架

JUL、JCL、Jboss-logging、logback、log4j、log4j2、slf4j....

| 日志门面  （日志的抽象层）                                   | 日志实现                                         |
| ------------------------------------------------------------ | ------------------------------------------------ |
| JCL（Jakarta  Commons Logging）   SLF4j（Simple  Logging Facade for Java）    jboss-logging | Log4j  JUL（java.util.logging）  Log4j2  Logback |

我们左边选一个门面（抽象层）、右边来选一个实现；

日志门面：  SLF4J；

日志实现：Logback；

3、SpringBoot的日志框架

底层是Spring框架，Spring框架默认是用JCL；而SpringBoot选用 SLF4j和logback；

## 抽象层SLF4j使用

### 如何使用SLF4j

1、以后开发的时候，日志记录方法的调用，不应该来直接调用日志的实现类，而是调用日志抽象层里面的方法；

2、给系统里面导入slf4j的jar和 logback的实现jar包；

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    logger.info("Hello World");
  }
}
```

3、对于比较老的实现层，没有考虑到SLF4J这个抽象层，我们需要添加一个适配层来将抽象层和实现层联系起来。

比如slf4j-log4j2.jar适配层；

4、每一个日志的实现框架都有自己的配置文件。使用slf4j以后，配置文件还是做成日志实现框架自己本身的配置文件。

![日志框架](https://i.ibb.co/4pfB4b3/image.png)

### 遗留问题

1、我们开发的系统使用的是（slf4j+logback）

但是这个系统是基于其他系统开发的，其他系统用了其他的框架：Spring（commons-logging）、Hibernate（jboss-logging）、MyBatis、xxxx

2、所以应该如何统一日志记录呢？如何使别的框架和我一起统一使用slf4j进行输出？

（1）将系统中其他日志框架先排除出去；

（2）用中间包来替换原有的日志框架；

（3）我们导入slf4j其他的实现。

![遗留问题](https://i.ibb.co/M1XgMPs/image.png)

## SpringBoot日志关系

1、SpringBoot日志的依赖关系

```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
```

SpringBoot使用它来做日志功能；

```xml
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-logging</artifactId>
		</dependency>
```

底层依赖关系

![日志依赖关系](https://i.ibb.co/Yy21XYp/image.png)

2、SpringBoot底层是使用slf4j+logback的方式进行日志记录

3、SpringBoot也把其他的日志都替换成了slf4j，替换包中实际使用的是SLF4J的类；

```java
@SuppressWarnings("rawtypes")
public abstract class LogFactory {

    static String UNSUPPORTED_OPERATION_IN_JCL_OVER_SLF4J = "http://www.slf4j.org/codes.html#unsupported_operation_in_jcl_over_slf4j";

    static LogFactory logFactory = new SLF4JLogFactoy();
```

4、如果我们要引入其他框架，一定要把这个框架的默认日志依赖移除掉。

比如Spring框架用的是commons-logging，在springboot引入spring-core依赖时就将commons-logging排除了；

```xml
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<exclusions>
				<exclusion>
					<groupId>commons-logging</groupId>
					<artifactId>commons-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
```

5、pringBoot能自动适配所有的日志，而且底层使用slf4j+logback的方式记录日志，引入其他框架的时候，只需要把这个框架依赖的日志框架排除掉即可。

## 日志使用

### 默认配置

1、SpringBoot实际上已经默认帮我们配置好了日志，所以直接启动主程序就有日志在控制台中输出；

2、springboot默认输出info级别及以上的日志

```java
    // 记录器
    Logger logger= LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
        //日志的级别；
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        // SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }
```

打印日志

```
2019-07-14 14:08:32.230  INFO 13364 --- [           main] .w.s.Springboot03LoggingApplicationTests : 这是info日志...
2019-07-14 14:08:32.230  WARN 13364 --- [           main] .w.s.Springboot03LoggingApplicationTests : 这是warn日志...
2019-07-14 14:08:32.230 ERROR 13364 --- [           main] .w.s.Springboot03LoggingApplicationTests : 这是error日志...
```

4、SpringBoot修改日志的默认配置

（1）在配置文件application.properties中添加日志显示级别的设置

```properties
logging.level.com.wjy=trace
```

输出日志

```
2019-07-14 14:12:16.207 TRACE 10968 --- [           main] .w.s.Springboot03LoggingApplicationTests : 这是trace日志...
2019-07-14 14:12:16.207 DEBUG 10968 --- [           main] .w.s.Springboot03LoggingApplicationTests : 这是debug日志...
2019-07-14 14:12:16.207  INFO 10968 --- [           main] .w.s.Springboot03LoggingApplicationTests : 这是info日志...
2019-07-14 14:12:16.207  WARN 10968 --- [           main] .w.s.Springboot03LoggingApplicationTests : 这是warn日志...
2019-07-14 14:12:16.208 ERROR 10968 --- [           main] .w.s.Springboot03LoggingApplicationTests : 这是error日志...
```

（2）将日志保存到文件中

```properties
#logging.path=
# 不指定路径在当前项目下生成springboot.log日志
# 可以指定完整的路径；
#logging.file=G:/springboot.log

# 在当前磁盘的根路径下创建spring文件夹和里面的log文件夹；使用 spring.log 作为默认文件
logging.path=/spring/log
```

| logging.file | logging.path | Example  | Description                        |
| ------------ | ------------ | -------- | ---------------------------------- |
| (none)       | (none)       |          | 只在控制台输出                     |
| 指定文件名   | (none)       | my.log   | 输出日志到my.log文件               |
| (none)       | 指定目录     | /var/log | 输出到指定目录的 spring.log 文件中 |

（3）日志输出格式

```
    日志输出格式：
		%d表示日期时间，
		%thread表示线程名，
		%-5level：级别从左显示5个字符宽度
		%logger{50} 表示logger名字最长50个字符，否则按照句点分割。 
		%msg：日志消息，
		%n是换行符
    -->
    %d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n
```

```properties
#  在控制台输出的日志的格式
logging.pattern.console=%d{yyyy-MM-dd} [%thread] %-5level %logger{50} - %msg%n
# 指定文件中日志输出的格式
logging.pattern.file=%d{yyyy-MM-dd} === [%thread] === %-5level === %logger{50} ==== %msg%n
```

### 指定配置

## 切换日志框架