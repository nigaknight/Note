# Spring

## Spring 概述

### Spring是什么

1、Spring是一个开源框架

2、Spring的目的是简化企业级应用开发

3、Spring是一个IOC和AOP框架

4、Spring的特征：轻量级、依赖注入、面向切面编程、容器

框架：Spring 实现了使用简单的组件配置组合成一个复杂的应用. 在 Spring 中可以使用 XML 和 Java 注解组合这些对象

一站式：在 IOC 和 AOP 的基础上可以整合各种企业应用的开源框架和优秀的第三方类库 

>IOC的好处：对象的构建如果依赖非常多的对象，且层次很深，外层在构造对象时很麻烦且不一定知道如何构建这么多层次的对象。IOC帮我们管理对象的创建，只需要在配置文件里指定如何构建，每一个对象的配置文件都在类编写的时候指定了，所以最外层对象不需要关心深层次对象如何创建的，前人都写好了。
>
>也就是说，通过IOC，将一个复杂的对象创建过程给封装起来，使用者可以非常方便的获取对象，这在一个对象创建时依赖其他数量多、层次深的对象的时候优点尤其明显。

### Spring核心组件介绍

1、spring总共有十几个组件，但是真正核心的组件只有几个。Spring框架中的核心组件只有三个：Core、Context和Beans。它们构建起了整个Spring的骨骼架构。没有它们就不可能有AOP、Web等上层的特性功能。下面也将主要从这三个组件入手分析Spring。

2、Bean在Spring中作用就像Object对OOP的意义一样，没有对象的概念就像没有面向对象编程，Spring中没有Bean也就没有Spring存在的意义。Spring解决了一个非常关键的问题他可以让 你把对象之间的依赖关系转而用配置文件来管理，也就是他的依赖注入机制。而这个注入关系在一个叫Ioc容器中管理，那Ioc容器中有又是什么就是被Bean包裹的对象。Spring正是通过把对象包装在 Bean中而达到对这些对象管理以及一些列额外操作的目的。

3、如果将Bean比作一场演出中的演员的话，那Context就是这场演出的舞台背景，而Core应该就是演出的道具了。

4、我们知道Bean包装的是Object，而Object必然有数据，如何给这些数据提供生存环境就是Context要解决的问题，对Context来说他就是要发现每个Bean之间的关系，为它们建立这种关系并且要维护好 这种关系。所以Context就是一个Bean关系的集合，这个关系集合又叫Ioc容器，一旦建立起这个Ioc容器后Spring就可以为你工作了。那Core组件又有什么用武之地呢？其实Core就是发现、建立和维护每 个Bean之间的关系所需要的一些列的工具，从这个角度看来，Core这个组件叫Util更能让你理解。

### Spring模块

核心容器

1、Beans,Core,Context,SpEL

2、Date Access/Itegration

3、Web

### 安装Spring Tool SUITE

eclipse需要安装Spring工具插件才能建立Spring工程；

Spring的安装有以下两个方法：

1、在[Spring官网](https://spring.io/tools3/sts/all/)下载eclipse对应版本的Spring安装包，注意安装包必须以updatesite结尾。

>对应eclipse 4.9.0的链接地址是 https://download.springsource.com/release/TOOLS/update/3.9.8.RELEASE/e4.9/springsource-tool-suite-3.9.8.RELEASE-e4.9.0-updatesite.zip
，如果需要其他版本，可以将其中的数字改成相应版本。

>遇到的问题：我所需要的4.5.0版本找不到对应的安装包链接地址。

2、使用网络链接地址

>使用这个链接 http://dist.springsource.com/release/TOOLS/update/e4.X/ 可以插入你的 Eclipse 的版本，再匹配其中的“x”，例如我的 Eclipse Neon.2 Release (4.6.2) ，安装时使用 http://dist.springsource.com/release/TOOLS/update/e4.6/ 

>遇到的问题：我的eclipse mars 4.5版本用这个方法可以安装STS，但是安装完成后Spring并没有显示。

最终还是更换了最新的eclipse 4.11.0。发现这个版本的eclipse自带Spring。

### 搭建Spring开发环境

将以下五个包加入项目中的classpath（五个包需要自己从网上下载）

Spring核心包：beans,context,core,experssion （来自Spring框架的lib里面）

Spring日志包：commons-logging

> 使用maven导入Spring开发环境：导入spring核心组件context的依赖即可（它会自动添加其他所需spring依赖）。
>

```xml
<!--pom.xml-->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-context</artifactId>
	    <version>5.1.5.RELEASE</version>
	</dependency>
```

### 建立Spring项目

1、创建一个HelloWorld项目，输出"Hello world "+"your name"。


```java
// helloworld.HelloWorld

public class HelloWorld {
    private String name;
    public void setName(String name){
        this.name=name;
    }
    public void hello(){
        System.out.println("hello world "+ name);
    }
}
```


创建对象以及为属性赋值交给Spring解决。

2、创建一个Spring项目，(src) New->Spring Bean Configuration File，创建文件applicationContext.xml，在这个文件下配置bean。

>配置bean的xml文件可以取任意的名字，不一定要是applicationContext.xml；applicationContext是创建IOC容器的类名。


```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--配置bean
        class：bean的全类名，通过反射的方式在IOC中创建bean，所以要求bean中必须有无参的构造器
        id：标识容器中的bean，id唯一
    -->
    <bean id="helloworld" class="helloworld.HelloWorld">
        <property name="name" value="wjy"/>
    </bean>
</beans>
```


id：标识对象（自己命名的对象名，作为getbean方法的参数标识）

class：要配置的类名（使用反射方式创建对象）

property：name表示要赋值的属性，value表示要赋的值

3、创建Spring的IOC容器对象

```java
public class Main {
	public static void main(String[] args) {
        // HelloWorld helloworld=new HelloWorld();
        // helloworld.setName("spring");
        // A 创建Spring的IOC容器
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		// B 从容器中获取Bean
		HelloWorld helloworld=(HelloWorld) applicationContext.getBean("helloworld");
		// C 调用Hello方法
		helloworld.hello();
	}
}
```

> 如果想要最后关闭IOC容器，需要将applicationContext一开始就设置为（或者最后类型转换为）ApplicaitonContext的子类，就可以调用close方法了。  

（1）创建Spring的IOC容器

>applicationContext：Spring的IOC容器接口
>
>ClassPathXmlApplicationContext：上述接口的实现类

（2）从容器中获取Bean

>getBean()方法：从IOC容器中获取Bean实例

（3）调用Hello方法

分析：创建IOC容器的时候，会调用类构造器，对bean初始化，并对属性进行赋值。

## IOC容器和Bean的配置

### IOC和DI

#### IOC的产生背景

对象创建方式的演变

1、分离接口和实现

2、采用工厂设计模式

3、采用控制反转

#### IOC

IOC（控制反转）：容器主动将资源推送给它所管理的组件，组件所要做的仅是选择一种合适的方法来接受资源。

#### DI

DI（依赖注入）：反转资源的获取方式。（和依赖注入是一种方法的两种表达）

#### IOC 容器在 Spring 中的实现 

在通过 IOC 容器读取 Bean 的实例之前， 需要先将 IOC 容器本身实例化。 

Spring 提供了 IOC 容器的两种实现方式 

1、BeanFactory： IOC 容器的基本实现， 是 Spring 内部的基础设施， 是面向 Spring 本身的， 不是提供给开发人员使用的。 

2、ApplicationContext： BeanFactory 的子接口， 提供了更多高级特性。 面向Spring 的 使 用 者 ， 几 乎 所 有 场 合 都 使 用 ApplicationContext 而 不 是 底 层 的BeanFactory 

#### ApplicationContext 的主要实现类 

1、ClassPathXmlApplicationContext： 对应类路径下的 XML 格式的配置文件

2、FileSystemXmlApplicationContext： 对应文件系统中的 XML 格式的配置文件

3、在初始化时就创建单例的 bean， 也可以通过配置的方式指定创建的 Bean 是多实例的。 

4、ConfigurableApplicationContext ：是 ApplicationContext 的子接口， 包含一些扩展方法 refresh()和 close()让 ApplicationContext 具有启动、 关闭和刷新上下文的能力。 

5、WebApplicationContext ：专门为 WEB 应用而准备的， 它允许从相对于 WEB 根目录的路径中完成初始化工作 

### 通过类型获取 bean 

#### 通过id获取

```java
HelloWorld helloworld = cxt.getBean("helloworld");
```

#### 通过类型获取

```java
HelloWorld helloWorld = cxt.getBean(HelloWorld. class);
```

#### 通过id和类型获取

```java
HelloWorld helloWorld = cxt.getBean(“helloWorld”,HelloWorld. class)
```

### 给Bean的属性赋值

#### 依赖注入的方式

##### 属性注入

•属性注入即通过 setter 方法注入Bean 的属性值或依赖的对象

•属性注入使用 <property> 元素, 使用 name 属性指定 Bean 的属性名称，value 属性或 <value> 子节点指定属性值 

•属性注入是实际应用中最常用的注入方式

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="helloworld" class="helloworld.HelloWorld">
        <!--这里的name对应setter方法set后面的字符，而不是属性本身-->
        <property name="name" value="wjy"/>
    </bean>
</beans>
```

##### 构造器注入

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--配置bean
        class：bean的全类名，通过反射的方式在IOC中创建bean，所以要求bean中必须有无参的构造器
        id：标识容器中的bean，id唯一
    -->
    <bean id="helloworld" class="helloworld.HelloWorld">
        <property name="name" value="wjy"/>
    </bean>
    <!--Spring 自动匹配合适的构造器
        通过索引值index指定参数位置
        通过类型type区分重载的构造器
    -->
    <bean id="car1" class="helloworld.Car">
        <constructor-arg value="Audi" type="java.lang.String" index="0"></constructor-arg>
        <constructor-arg value="Shanghai" type="java.lang.String" index="1"></constructor-arg>
        <constructor-arg value="300000" type="double" index="2"></constructor-arg>
    </bean>

    <bean id="car2" class="helloworld.Car">
        <constructor-arg value="Dazhong" type="java.lang.String" index="0"></constructor-arg>
    <!-- 若字面值中包含特殊字符，可以使用 <![CDATA[]]> 把字面值包裹起来。-->
        <constructor-arg type="java.lang.String" index="1">
            <value><![CDATA[Shanghai^]]></value>
        </constructor-arg>
        <constructor-arg type="int" index="2">
    <!-- 可以使用<value> 子节点指定属性值  -->
            <value>250</value>
        </constructor-arg>
    </bean>
</beans>
```

##### 工厂方法注入

很少使用，不推荐

1、静态工厂方法注入

静态工厂方法注入不需要创建静态类的对象

静态工厂

```java
public class StaticCarFactory {
    private static Map<String,Car> cars=new HashMap<String,Car>();

    static {
        cars.put("Audi",new Car("Audi",300000.00));
        cars.put("Ford",new Car("Ford",400000.00));
    }

    public static Car getCar(String brand){
        return cars.get(brand);
    }
}
```

使用静态工厂方法注入bean

```xml
    <bean id="car" class="beanFactory.StaticCarFactory" factory-method="getCar">
        <constructor-arg value="Audi"></constructor-arg>
    </bean>
```

输出Car对象

```
通过静态工程方法获取bean
Car{brand='Audi', price=300000.0}
```

2、实例工厂方法注入

实例工厂

```java
public class InstanceCarFactory {
    private Map<String,Car> cars=null;

    public InstanceCarFactory(){
        cars=new HashMap<String, Car>();
        cars.put("Audi",new Car("Audi",300000.00));
        cars.put("Ford",new Car("Ford",400000.00));
    }

    public Car getCar(String brand){
        return cars.get(brand);
    }
}
```

使用实例工厂方法注入bean

```xml
    <bean id="carFactory" class="beanFactory.InstanceCarFactory"></bean>

    <bean id="car2" factory-bean="carFactory" factory-method="getCar">
        <constructor-arg value="Ford"></constructor-arg>
    </bean>
```

输出Car对象

```
通过实例工厂方法获取bean
Car{brand='Ford', price=400000.0}
```

#### p命名空间

为了简化 XML 文件的配置， 越来越多的 XML 文件采用属性而非子元素配置信息。Spring从 2.5 版本开始引入了一个新的 p 命名空间，可以通过<bean>元素属性的方式配置 Bean的属性。使用 p 命名空间后， 基于 XML 的配置方式将进一步简化 。

```xml
    <bean id="person8" class="beanCollection.Person" p:name="dzq" p:age="27" p:cars-ref="cars"></bean>
```

输出

```
第八个人：使用p命名空间
Person{name='dzq', age=27, cars=[Car{brand='Audi', corp='Shanghai', price=300000.0, maxSpeed=0}, Car{brand='Dazhong', corp='Shanghai^', price=0.0, maxSpeed=250}]}
```

#### 可以使用的值

##### 字面值

1) 可以使用字符串表示的值， 可以通过 value 属性或 value 子节点的方式指定

2) 基本数据类型及其封装类、 String 等类型都可以采取字面值注入的方式

3) 若字面值中包含特殊字符， 可以使用<![CDATA[]]>把字面值包裹起来 

##### null值

赋值null，一般用不到，因为不赋值其实就是赋值null

```xml
<!--    没有车：赋值null-->
    <bean id="person3" class="beanAttribute.Person">
        <constructor-arg value="dzq" ></constructor-arg>
        <constructor-arg value="27"></constructor-arg>
        <constructor-arg><null/></constructor-arg>
    </bean>
```

输出

```
第三个人：测试赋值null
Person{name='dzq', age=27, car=null}
```

##### 给 bean 的级联属性赋值 

```xml
    <bean id="person4" class="beanAttribute.Person">
        <constructor-arg value="dzq"></constructor-arg>
        <constructor-arg value="27"></constructor-arg>
        <constructor-arg ref="car3"></constructor-arg>
        <property name="car.maxSpeed" value="250"></property>
    </bean>
```

输出（可以给car的属性maxSpeed赋值）

```
第四个人：测试级联属性赋值
Person{name='dzq', age=27, car=Car{brand='benchi', corp='Beijing', price=400000.0, maxSpeed=250}}
```

注意：属性需要先初始化才可以给级联属性赋值，否则会有异常，比如这个例子中，给car.maxSpeed赋值时如果car本身没有初始化，则会有异常。

##### 外部已声明的 bean 

```xml
    <!-- ref引用外部已经声明的bean，建立bean之间的依赖关系-->
    <bean id="person" class="helloworld.Person">
        <property name="name" value="wjy"></property>
        <property name="age" value="23"></property>
        <property name="car" ref="car1"></property>
    </bean>
```

##### 内部 bean 

当 bean 实例仅仅给一个特定的属性使用时， 可以将其声明为内部 bean。 内部 bean 声明直接包含在<property>或<constructor-arg>元素里， 不需要设置任何 id或 name 属性 。

内部 bean 不能使用在任何其他地方 。

```xml
    <!-- 使用内部bean创建一个有car的person   -->
    <bean id="person2" class="beanAttribute.Person">
        <property name="name" value="zjl"></property>
        <property name="age" value="35"></property>
        <property name="car">
            <bean class="beanAttribute.Car">
                <constructor-arg name="brand" value="baoma"></constructor-arg>
                <constructor-arg name="corp" value="BWM"></constructor-arg>
                <constructor-arg name="price" value="250000.00"></constructor-arg>
            </bean>
        </property>
    </bean>
```

### 集合属性

在 Spring 中可以通过一组内置的 XML 标签来配置集合属性， 例如： <list>， <set>或<map>。 

#### 数组和 List 

配置 java.util.List 类型的属性， 需要指定<list>标签， 在标签里包含一些元素。 这些标签可以通过<value>指定简单的常量值， 通过<ref>指定对其他 Bean 的引用。 通过<bean>指定内置 bean 定义。 通过<null/>指定空元素。 甚至可以内嵌其他集合。数组的定义和 List 一样， 都使用<list>元素。配置 java.util.Set 需要使用<set>标签， 定义的方法与 List 一样。 

```xml
    <bean id="person5" class="beanCollection.Person">
        <constructor-arg value="dzq"></constructor-arg>
        <constructor-arg value="27"></constructor-arg>
        <constructor-arg>
            <list>
                <ref bean="car1"></ref>
                <ref bean="car2"></ref>
                <ref bean="car3"></ref>
            </list>
        </constructor-arg>
    </bean>
```

另一种写法

```xml
    <bean id="person5" class="beanCollection.Person">
        <property name="name" value="dzq"></property>
        <property name="age" value="27"></property>
        <property name="cars">
            <list>
                <ref bean="car1"></ref>
                <ref bean="car2"></ref>
                <ref bean="car3"></ref>
            </list>
        </property>
    </bean>
```

其实就是将写value的地方用list来代替；

输出

```
第五个人：测试集合属性
Person{name='dzq', age=27, cars=[Car{brand='Audi', corp='Shanghai', price=300000.0, maxSpeed=0}, Car{brand='Dazhong', corp='Shanghai^', price=0.0, maxSpeed=250}, Car{brand='benchi', corp='Beijing', price=400000.0, maxSpeed=250}]}
```

#### Map 

Java.util.Map 通过<map>标签定义， <map>标签里可以使用多个<entry>作为子标签。 每个条目包含一个键和一个值。

必须在<key>标签里定义键。

因为键和值的类型没有限制， 所以可以自由地为它们指定<value>、 <ref>、 <bean>或<null/>元素。

可以将 Map 的键和值作为<entry>的属性定义： 简单常量使用 key 和 value 来定义； bean引用通过 key-ref 和 value-ref 属性定义 

```xml
    <bean id="person6" class="beanCollection.NewPerson" >
        <property name="name" value="dzq"></property>
        <property name="age" value="27"></property>
        <property name="cars">
            <map>
                <entry key="AA" value-ref="car1"></entry>
                <entry key="BB" value-ref="car2"></entry>
            </map>
        </property>
    </bean>
```

这里NewPerson这个类的cars对象是Map类型的。

输出

```
第六个人：测试map集合
NewPerson{name='dzq', age=27, cars={AA=Car{brand='Audi', corp='Shanghai', price=300000.0, maxSpeed=0}, BB=Car{brand='Dazhong', corp='Shanghai^', price=0.0, maxSpeed=250}}}
```

#### Props

使用 <props> 定义 java.util.Properties, 该标签使用多个 <prop> 作为子标签. 每个 <prop> 标签必须定义 key 属性. 

> properties实际上是一个map的一个实现子类，所以和map的配置方式很像，数据库的连接就需要用到properties。子标签中的配置方式和<entry>略有不同，值应该在<prop>标签中间，如`<prop key="user">root</prop>`。

```xml
<!--配置数据源：测试props集合属性-->
    <bean id="dataSource" class="beanCollection.Datasource">
        <property name="properties">
            <props>
                <prop key="user">user</prop>
                <prop key="password">123456</prop>
                <prop key="jdbcUrl">jdbc:mysql:///test</prop>
                <prop key="driverClass">com.mysql.jdbc.Driver</prop>
            </props>
        </property>
    </bean>
```

输出

```
配置数据源：测试prop集合
Datasource{properties={password=123456, driverClass=com.mysql.jdbc.Driver, jdbcUrl=jdbc:mysql:///test, user=user}}
```

#### 集合类型的 bean 

如果只能将集合对象配置在某个 bean 内部， 则这个集合的配置将不能重用。 我们需要将集合 bean 的配置拿到外面， 供其他 bean 引用。

配置集合类型的 bean 需要引入 util 名称空间 。

```xml
    <util:list id="cars">
        <ref bean="car1"></ref>
        <ref bean="car2"></ref>
    </util:list>

    <bean id="person7" class="beanCollection.Person">
        <property name="name" value="dzq"></property>
        <property name="age" value="27"></property>
        <property name="cars" ref="cars"></property>
    </bean>
```

输出

```
第七个人：测试外部集合
Person{name='dzq', age=27, cars=[Car{brand='Audi', corp='Shanghai', price=300000.0, maxSpeed=0}, Car{brand='Dazhong', corp='Shanghai^', price=0.0, maxSpeed=250}]}
```

### FactoryBean 

Spring 中有两种类型的 bean， 一种是普通 bean， 另一种是工厂 bean， 即 FactoryBean。工厂 bean 跟普通 bean 不同， 其返回的对象不是指定类的一个实例， 其返回的是该工厂 bean 的 getObject 方法所返回的对象。

工厂 bean 必须实现 org.springframework.beans.factory.FactoryBean 接口。 

实现FactoryBean接口

```java
public class CarFactoryBean implements FactoryBean {
    private String brand;
	
    public void setBrand(String brand){
        this.brand=brand;
    }
	
    // 最重要的方法，最后该工厂bean返回的就是getObject方法返回的对象
    public Object getObject() throws Exception {
        return new Car(brand,500000);
    }
	
    // 获取bean的类型
    public Class<?> getObjectType() {
        return Car.class;
    }
	
    // 获取bean是否单例
    public boolean isSingleton() {
        return true;
    }
}
```

注入bean，注入的是工厂bean，但是返回的是getObject方法返回的对象

```xml
    <bean id="car" class="beanFactoryBean.CarFactoryBean">
        <property name="brand" value="BMW"></property>
    </bean>
```

> 通过使用FactoryBean，我们可以得到不同类型的对象实例。这也就是我们在AOP中通过设置class为ProxyFactoryBean可以返回不同类型的业务对象的原理。在实际应用中若能灵活使用FactoryBean，则可以给应用程序增加很多的魔幻功能。

> FactoryBean 通常是用来创建比较复杂的bean，一般的bean 直接用xml配置即可，但如果一个bean的创建过程中涉及到很多其他的bean 和复杂的逻辑，用xml配置比较困难，这时可以考虑用FactoryBean。

> 很多开源项目在集成Spring 时都使用到FactoryBean，比如 MyBatis3提供 mybatis-spring项目中的 `org.mybatis.spring.SqlSessionFactoryBean`

```xml
    <!-- spring和MyBatis整合，不需要mybatis的配置映射文件 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!-- 自动扫描mapping.xml文件 -->
        <property name="mapperLocations" value="classpath:mapper/*.xml"></property>
    </bean>
```

### bean 的高级配置 

#### 配置信息的继承 

##### 背景 

bean之间的配置存在重复

##### 配置信息的继承 

Spring 允许继承 bean 的配置， 被继承的 bean 称为父 bean。 继承这个父 bean 的 bean称为子 bean

子 bean 从父 bean 中继承配置， 包括 bean 的属性配置

子 bean 也可以覆盖从父 bean 继承过来的配置 

```xml
<bean id="address1" class="beanAutowire.Address" p:city="Nanjing" p:street="Taipingbeilu"></bean>
<bean id="address2" parent="address1" p:street="beijingdonglu"></bean>
```

输出

```
地址：使用bean的继承
Address{city='Nanjing', street='Taipingbeilu'}
Address{city='Nanjing', street='beijingdonglu'}
```

##### 补充说明 

父 bean 可以作为配置模板， 也可以作为 bean 实例。 若只想把父 bean 作为模板， 可以设置<bean>的 abstract 属性为 true， 这样 Spring 将不会实例化这个 bean

如果一个 bean 的 class 属性没有指定， 则必须是抽象 bean

并不是<bean>元素里的所有属性都会被继承。 比如： autowire， abstract 等。

也可以忽略父 bean 的 class 属性， 让子 bean 指定自己的类， 而共享相同的属性配置。 但此时 abstract 必须设为 true。 

#### bean 之间的依赖 

有的时候创建一个 bean 的时候需要保证另外一个 bean 也被创建， 这时我们称前面的 bean 对后面的 bean 有依赖。 例如： 要求创建 Employee 对象的时候必须创建 Department。

这里需要注意的是依赖关系不等于引用关系， Employee 即使依赖 Department 也可以不引用它 

```xml
<bean id="car" class="beanAutowire.Car" p:brand="baoma" p:price="300000"></bean>
<bean id="person" class="beanAutowire.Person" p:name="dzq" p:address-ref="address2" depends-on="car"></bean>
```

输出

```
第三个人：测试bean的依赖关系
Person{name='dzq', address=Address{city='Nanjing', street='beijingdonglu'}, car=null}
```

如果上面没有创建car的bean，那么由于person的bean依赖于car，将会抛出异常。

上面的person依赖于car，但是没有引用car，所以输出的car依然是null。

### bean 的作用域 

在 Spring 中， 可以在<bean>元素的 scope 属性里设置 bean 的作用域， 以决定这个 bean是单实例的还是多实例的。

默认情况下， Spring 只为每个在 IOC 容器里声明的 bean 创建唯一一个实例， 整个 IOC容器范围内都能共享该实例： 所有后续的 getBean()调用和 bean 引用都将返回这个唯一的bean 实例。 该作用域被称为 singleton， 它是所有 bean 的默认作用域。 

当 bean 的作用域为单例时， Spring 会在 IOC 容器对象创建时就创建 bean 的对象实例。而当 bean 的作用域为 prototype 时， IOC 容器在获取 bean 的实例时创建 bean 的实例对象。 

```xml
 <bean id="car" class="beanAutowire.Car" p:brand="baoma" p:price="300000" scope="singleton"></bean>
```

```java
Car car1 = (Car) applicationContext.getBean("car");
Car car2 = (Car) applicationContext.getBean("car");
System.out.println(car1==car2);
```

输出

```
true
```

默认作用域为singleton，是单例，所以两辆车实际上是一辆。

将scope改为prototype

```xml
 <bean id="car" class="beanAutowire.Car" p:brand="baoma" p:price="300000" scope="prototype"></bean>
```

输出

```
false
```

### bean 的生命周期 

1、Spring IOC 容器可以管理 bean 的生命周期， Spring 允许在 bean 生命周期内特定的时间点执行指定的任务。 

2、Spring IOC 容器对 bean 的生命周期进行管理的过程：

（1）通过构造器或工厂方法创建 bean 实例
（2）为 bean 的属性设置值和对其他 bean 的引用
（3）调用 bean 的初始化方法
（4） bean 可以使用了
（5）当容器关闭时， 调用 bean 的销毁方法 

3、在配置 bean 时， 通过 init-method 和 destroy-method 属性为 bean 指定初始化和销毁方法 。

Car类

```java
public class Car {
    public Car(){
        System.out.println("Car's Constructor...");
    }

    private String brand;

    public void setBrand(String brand){
        System.out.println("setBrand...");
        this.brand=brand;
    }

    public void init(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }
}
```

bean配置

```xml
    <bean id="car" class="beanCycle.Car" init-method="init" destroy-method="destroy">
        <property name="brand" value="Audi"></property>
    </bean>
```

打印Car对象

```java
ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cycle.xml");
Car car=(Car) ctx.getBean("car");
System.out.println(car);
```

输出

```java
Car's Constructor... //调用构造函数初始化，创建bean实例
setBrand...  // 为bean的属性设置值
init...  // 调用bean的初始化方法
beanCycle.Car@38c5cc4c //bean可以用了
destroy... //调用bean的销毁方法
```

4、bean 的后置处理器 

（1） bean 后置处理器允许在调用初始化方法前后对 bean 进行额外的处理

（2） bean 后置处理器对 IOC 容器里的所有 bean 实例逐一处理， 而非单一实例。 其典型应用是： 检查 bean 属性的正确性或根据特定的标准更改 bean 的属性。

（3）bean 后置处理器时需要实现接口：org.springframework.beans.factory.config.BeanPostProcessor。 在初始化方法被调用前后， Spring 将把每个 bean 实例分别传递给上述接口的以下两个方法：

```java
postProcessBeforeInitialization(Object, String)
postProcessAfterInitialization(Object, String) 
```

实现BeanPostProcessor接口的方法

```java
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:"+bean+","+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:"+bean+","+beanName);
        return bean;
    }
}
```

配置实现BeanPostProcessor接口的类的bean

```xml
<bean class="beanCycle.MyBeanPostProcessor"></bean>
```

输出（在bean的可用期前后分别执行后处理方法）

```
Car's Constructor...
setBrand...
postProcessBeforeInitialization:beanCycle.Car@402e37bc,car
init...
postProcessAfterInitialization:beanCycle.Car@402e37bc,car
beanCycle.Car@402e37bc
destroy...
```

5、添加 bean 后置处理器后 bean 的生命周期 

（1）通过构造器或工厂方法创建 bean 实例
（2）为 bean 的属性设置值和对其他 bean 的引用
（3）将 bean 实例传递给 bean 后置处理器的 postProcessBeforeInitialization()方法
（4）调用 bean 的初始化方法
（5）将 bean 实例传递给 bean 后置处理器的 postProcessAfterInitialization()方法
（6）bean 可以使用了 
（7）当容器关闭时调用 bean 的销毁方法 

### 引用外部属性文件 

当 bean 的配置信息逐渐增多时， 查找和修改一些 bean 的配置信息就变得愈加困难。 这时可以将一部分信息提取到 bean 配置文件的外部， 以 properties 格式的属性文件保存起来，同时在 bean 的配置文件中引用 properties 属性文件中的内容， 从而实现一部分属性值在发生变化时仅修改 properties 属性文件即可。 这种技术多用于连接数据库的基本信息的配置 

#### 直接配置 

使用c3p0定义数据库连接

```xml
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="user" value="root"></property>
        <property name="password" value="12345678"></property>
        <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql:///test"></property>
    </bean>
```

将数据源的连接打印出来

```java
ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-properties.xml");
ComboPooledDataSource dataSource = (ComboPooledDataSource) applicationContext.getBean("dataSource");
System.out.println(dataSource.getConnection());
```

输出

```
com.mchange.v2.c3p0.impl.NewProxyConnection@2ddc9a9f
```

#### 使用外部的属性文件 

> 使用外部属性文件可以将配置文件单独维护；

创建 properties 属性文件 

```properties
username=root
password=12345678
driverClass=com.mysql.jdbc.Driver
jdbcUrl=jdbc:mysql:///test
```

引入 context 名称空间 

指定 properties 属性文件的位置 

从 properties 属性文件中引入属性值 

```xml
    <context:property-placeholder location="classpath:db.properties"/>
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="user" value="${user}"></property>
        <property name="password" value="${password}"></property>
        <property name="driverClass" value="${driverClass}"></property>
        <property name="jdbcUrl" value="${jdbcUrl}"></property>
    </bean>
```

最后的输出和直接配置的结果相同，但是数据库的属性可以单独维护了。

### 自动装配 

#### 自动装配的概念 

1) 手动装配： 以 value 或 ref 的方式明确指定属性值都是手动装配。

2) 自动装配： 根据指定的装配规则， 不需要明确指定， Spring 自动将匹配的属性值注入bean 中。 

#### 装配模式 

1) 根据类型自动装配： 将类型匹配的 bean 作为属性注入到另一个 bean 中。 若 IOC 容器中有多个与目标 bean 类型一致的 bean， Spring 将无法判定哪个 bean 最合适该属性， 所以不能执行自动装配

```xml
    <bean id="person2" class="beanAutowire.Person" p:name="dzq2" autowire="byType"></bean>
```

输出

```
第二个人：使用按类型自动装配
Person{name='dzq2', address=Address{city='Shanghai', street='nanjing street'}, car=Car{brand='baoma', price=300000.0}}
```

2) 根据名称自动装配： 必须将目标 bean 的名称和属性名设置的完全相同

```xml
    <bean id="car" class="beanAutowire.Car" p:brand="baoma" p:price="300000"></bean>

    <bean id="address" class="beanAutowire.Address" p:city="Shanghai" p:street="nanjing street"></bean>

    <bean id="person" class="beanAutowire.Person" p:name="dzq" autowire="byName"></bean>
```

Person类中的Car和address属性的getter和setter方法的名字和car、address的id名相同，这之后才能装配成功。

```
第一个人：使用按名字自动装配
Person{name='dzq', address=Address{city='Shanghai', street='nanjing street'}, car=Car{brand='baoma', price=300000.0}}
```

3) 通过构造器自动装配： 当 bean 中存在多个构造器时， 此种自动装配方式将会很复杂。不推荐使用 

#### 选用建议 

相对于使用注解的方式实现的自动装配， 在 XML 文档中进行的自动装配略显笨拙， 在项目中更多的使用注解的方式实现。 

### SpEL 

#### 简介 

Spring Expression Language， Spring 表达式语言， 简称 SpEL。 支持运行时查询并可以操作对象图。

和 JSP 页面上的 EL 表达式、 Struts2 中用到的 OGNL 表达式一样， SpEL 根据 JavaBean 风格的 getXxx()、 setXxx()方法定义的属性访问对象图， 完全符合我们熟悉的操作习惯。 

#### 基本语法 

SpEL 使用#{…}作为定界符， 所有在大框号中的字符都将被认为是 SpEL 表达式。 

##### 使用字面量 

1、整数： <property name="count" value="#{5}"/>
2、小数： <property name="frequency" value="#{89.7}"/>
3、科学计数法： <property name="capacity" value="#{1e4}"/>
4、String 类型的字面量可以使用单引号或者双引号作为字符串的定界符号
<property name="name" value="#{'Chuck'}"/>
<property name="name" value='#{"Chuck"}'/>
5、Boolean： <property name="enabled" value="#{false}"/> 

```xml
    <bean id="address" class="beanSpel.Address">
        <property name="city" value="#{'Beijing'}"></property>
        <property name="street" value="HuiLongGuan"></property>
    </bean>
```

输出Address对象

```
测试用spel为属性赋一个字面值
Address{city='Beijing', street='HuiLongGuan'}
```

仅仅是使用字面量的话，使用SpEL的意义不大；

##### 引用其他 bean 

使用spel可以引用其他bean或者其他bean的属性

```xml
    <bean id="person" class="beanSpel.Person">
        <property name="name" value="dzq"></property>
        <!--使用spel来引用其他的bean-->
        <property name="car" value="#{car}"></property>
        <!--使用spel来引用其他的bean的属性-->
        <property name="city" value="#{address.city}"></property>
        <!--在spel中使用运算符-->
        <property name="info" value="#{car.price>300000?'金领':'白领'}"></property>
    </bean>
```

输出Person对象

```
使用spel引用其他的bean、bean的属性；在spel中使用运算符
Person{name='dzq', city='Beijing', car=Car{brand='baoma', price=300000.0, tyrePerimeter=251.32741228718345}, info='白领'}
```

##### 调用方法

这里使用了Math包里面的pi来表示轮胎的周长

```xml
<bean id="car" class="beanSpel.Car">
    <property name="brand" value="baoma"></property>
    <property name="price" value="300000"></property>
    <property name="tyrePerimeter" value="#{T(java.lang.Math).PI*80}"></property>
</bean>
```

输出Car对象

```
使用spel调用静态方法
Car{brand='baoma', price=300000.0, tyrePerimeter=251.32741228718345}
```

##### 运算符 

1、算术运算符： +、 -、 *、 /、 %、 ^

2、字符串连接： +

3、 比较运算符： <、 >、 ==、 <=、 >=、 lt、 gt、 eq、 le、 ge

4、逻辑运算符： and, or, not, |

5、三目运算符： 判断条件?判断结果为 true 时的取值:判断结果为 false 时的取值

6、正则表达式： matches 

### 通过注解配置Bean

#### 概述

> 基于注解的形式配置bean在现在的开发中比较流行。
>
> 一般在类上面添加注解，注解可以为任意特定组件名，但建议和包的功能对应。在xml文件中配置了包扫描属性后，就会将这些包里面注解了的类全部装配成bean（如果不主动设置的话，这些bean的id即为第一个字母小写的类名）然后就可以在java文件中请求这些类的bean实例。

相对于 XML 方式而言， 通过注解的方式配置 bean 更加简洁和优雅， 而且和 MVC 组件化开发的理念十分契合， 是开发中常用的使用方式。 

#### 使用注解标识组件 

特定组件包括:

1、@Component: 基本注解, 标识了一个受 Spring 管理的组件

2、@Respository: 标识持久层组件

3、@Service: 标识服务层(业务层)组件

4、@Controller: 标识表现层组件

组件命名规则：

1、默认情况： 使用组件的简单类名首字母小写后得到的字符串作为 bean 的 id

2、使用组件注解的 value 属性指定 bean 的 id

注意： 事实上 Spring 并没有能力识别一个组件到底是不是它所标记的类型， 即使将@Respository 注解用在一个表述层控制器组件上面也不会产生任何错误， 所以@Respository、 @Service、 @Controller 这几个注解仅仅是为了让开发人员自己明确 当前的组件扮演的角色。 

> 实际上这几个注解在IOC中是可以混用的，因为IOC不能检测你标识的是什么层，但依然建议按照对应顺序注解。

```java
@Component
public class TestObject {
}
```

```java
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{
    public void save() {
        System.out.println("UserRepositoty save ...");
    }
}
```

注解的时候可以指定生成的bean的id，这里就指定了生成的bean的id为userRepository，否则默认为类名第一个字母小写（userRepositoryImpl）

```java
@Controller
public class UserController {
    public void execute(){
        System.out.println("UserController execute...");
    }
}
```

```java
@Service
public class UserService {
    public void add(){
        System.out.println("UserService add...");
    }
}
```

#### 扫描组件

组件被上述注解标识后还需要通过 Spring 进行扫描才能够侦测到。 

组件扫描(component scanning):  Spring 能够从 classpath 下自动扫描, 侦测和实例化具有特定注解的组件. 

对于扫描到的组件, Spring 有默认的命名策略: 使用非限定类名, 第一个字母小写. 也可以在注解中通过 value 属性值标识组件的名称

> 比如有一个类UserService，则它对应的IOC容器中bean的名字默认为userService，注解的作用之一就是指定这个名字。
>
> 指定通过注解装配bean名称的方法：如`@Repository("userRepository")`将bean名称命名为userRepository。

1、当在组件类上使用了特定的注解之后, 还需要在 Spring 的配置文件中声明 <context:component-scan> ：

```xml
<context:component-scan base-package="beanAnnotation"></context:component-scan>
```

base-package 属性指定一个需要扫描的基类包，Spring 容器将会扫描这个基类包里及其子包中的所有类. 当需要扫描多个包时, 可以使用逗号分隔.

2、如果仅希望扫描特定的类而非基包下的所有类，可使用 resource-pattern 属性过滤特定的类

```xml
<context:component-scan base-package="beanAnnotation" resource-pattern="service/*.class"></context:component-scan>
```

使用resource-pattern可以指定要扫描的包和文件类型。

3、<context:include-filter> 子节点表示要包含的目标类

4、<context:exclude-filter> 子节点表示要排除在外的目标类

```xml
<context:component-scan base-package="beanAnnotation">
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
</context:component-scan>
```

此时将不会扫描用@Repository注解的类，输出如下

```
Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'userRepository' available
```

5、<context:component-scan> 下可以拥有若干个 <context:include-filter> 和 <context:exclude-filter> 子节点

6、<context:include-filter> 和 <context:exclude-filter> 子节点支持多种类型的过滤表达式

> 需要导入context命名空间

- [ ] 在注解的方式中，如何给bean传入参数呢？

> 使用getBean方法获取bean对象后，就可以直接调用类方法，传入参数了。但是在注解的方式中如何使用setter方法或者构造方法传入参数呢？这点还不清楚，也就是我还找不到一个注解中对应于xml中property和construtor-arg属性或标签的功能。

#### 组件装配

##### 需求

Controller 组件中往往需要用到 Service 组件的实例， Service 组件中往往需要用到Repository 组件的实例。 Spring 可以通过注解的方式帮我们实现属性的装配。

##### 实现依据

在指定要扫描的包时， <context:component-scan> 元素会自动注册一个 bean 的后置处理器：AutowiredAnnotationBeanPostProcessor 的实例。 该后置处理器可以自动装配标记了@Autowired、 @Resource 或@Inject 注解的属性。

##### @Autowired 

1、根据类型实现自动装配。

2、构造器、 普通字段(即使是非 public)、 一切具有参数的方法都可以应用@Autowired注解

3、默认情况下， 所有使用@Autowired 注解的属性都需要被设置。 当 Spring 找不到匹配的 bean 装配属性时， 会抛出异常。

4、若某一属性允许不被设置， 可以设置@Autowired 注解的 required 属性为 false

5、默认情况下， 当 IOC 容器里存在多个类型兼容的 bean 时， Spring 会尝试匹配 bean的 id 值是否与变量名相同， 如果相同则进行装配。 如果 bean 的 id 值不相同， 通过类 型的自动装配将无法工作。此时可以@Qualifier 注解里提供 bean的名称。 Spring 甚至允许在方法的形参上标注@Qualifiter 注解以指定注入 bean 的名称。

6、@Autowired 注解也可以应用在数组类型的属性上， 此时 Spring 将会把所有匹配的bean 进行自动装配。

7、@Autowired 注解也可以应用在集合属性上， 此时 Spring 读取该集合的类型信息，然后自动装配所有与之兼容的 bean。

8、@Autowired 注解用在 java.util.Map 上时， 若该 Map 的键值为 String， 那么 Spring将自动装配与值类型兼容的 bean 作为值， 并以 bean 的 id 值作为键。

> 使用注解来建立bean和bean之间的引用关系

```java
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{
    public void save() {
        System.out.println("UserRepositoty save ...");
    }
}
```

```java
@Service
public class UserService {
    UserRepository userRepository;
    public void add(){
        System.out.println("UserService add...");
        userRepository.save();
    }
}
```

```java
@Controller
public class UserController {
    UserService userService;
    public void execute(){
        System.out.println("UserController execute...");
        userService.add();
    }
}
```

以上UserController类里面有UserService对象，并且调用了它的方法；UserService类里面有UserRepository对象，并且调用了它的方法。

```java
public static void main(String[] args) {
    // 通过注解配置bean之间的关系
    ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean-annotation.xml");
    UserController userController = (UserController) applicationContext.getBean("userController");
    userController.execute();
}
```

如果直接建立userController对象并调用它的方法，将会出错，因为userService和userRepository的bean都没有被装配。输出如下：

```
UserController execute...
Exception in thread "main" java.lang.NullPointerException
	at beanAnnotation.controller.UserController.execute
```

在UserController类和UserService类中使用到的其他类的对象声明上添加@Autowire注解，装配时将自动检测IOC容器中有没有类型匹配的bean，如果有就自动装配。

```java
@Controller
public class UserController {
    @Autowired
    UserService userService;
    public void execute(){
        System.out.println("UserController execute...");
        userService.add();
    }
}
```

输出

```
UserController execute...
UserService add...
UserRepositoty save ...
```

自动装配的前提是自动装配的bean被扫描了，否则会出错。但是，我们可以在@Autowire注解上添加require属性，这样，即使自动装配bean的不存在，也不会报错，而是赋值为null。

```java
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{
    @Autowired(required = false)
    private TestObject testObject;
    public void save() {
        System.out.println("UserRepositoty save ...");
        System.out.println(testObject);
    }
}
```

以上的TestObject类没有被扫描；输出如下

```
UserController execute...
UserService add...
UserRepositoty save ...
null
```

##### @Resource

@Resource 注解要求提供一个 bean 名称的属性， 若该属性为空， 则自动采用标注处的变量或方法名作为 bean 的名称。

##### @Inject

@Inject 和@Autowired 注解一样也是按类型注入匹配的 bean， 但没有 reqired 属性。 

### 泛型依赖注入

对于带有泛型的基类，它们的子类会继承基类之间的依赖关系；

下面是两个有依赖关系的基类BaseRepository和BaseService

```java
public class BaseRepository <T>{

}
```

```java
public class BaseService <T> {
    @Autowired
    BaseRepository<T> baseRepository;

    public void add(){
        System.out.println("add...");
        System.out.println(baseRepository);
    }
}
```

下面是它们的子类

```java
@Service
public class UserService extends BaseService<User> {

}
```

```java
@Repository
public class UserRepository extends BaseRepository<User> {

}
```

调用UserService的对象的add方法，输出如下

```
add...
beanGenericDi.UserRepository@702657cc
```

最后打印出来的是UserRepository，说明依赖关系被继承。

## AOP

### AOP前奏

#### 提出问题 

##### 情景： 数学计算器 

1、要求 

（1）执行加减乘除运算 ；

（2）日志： 在程序执行期间追踪正在发生的活动 ；

（3）验证： 希望计算器只能处理正数的运算 ；

2、常规实现 

直接在功能函数里面打印日志；

计算器类

```java
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    public int add(int i, int j) {
        System.out.println("The method add begins with["+i+","+j+"]");
        int result=i+j;
        System.out.println("The method add ends with "+result);
        return result;
    }

    public int sub(int i, int j) {
        System.out.println("The method sub begins with["+i+","+j+"]");
        int result=i-j;
        System.out.println("The method sub ends with "+result);
        return result;
    }

    public int mul(int i, int j) {
        System.out.println("The method mul begins with["+i+","+j+"]");
        int result=i*j;
        System.out.println("The method mul ends with "+result);
        return result;
    }

    public int div(int i, int j) {
        System.out.println("The method div begins with["+i+","+j+"]");
        int result=i/j;
        System.out.println("The method div ends with "+result);
        return result;
    }
}
```

调用add方法输出

```
The method add begins with[3,5]
The method add ends with 8
result:8
```

3、问题 ：

（1）代码混乱： 越来越多的非业务需求(日志和验证等)加入后， 原有的业务方法急剧膨胀。 每个方法在处理核心逻辑的同时还必须兼顾其他多个关注点。 

（2）代码分散: 以日志需求为例， 只是为了满足这个单一需求， 就不得不在多个模块（方法） 里多次重复相同的日志代码。 如果日志需求发生变化， 必须修改所有模块 

#### 动态代理 

##### 动态代理的原理 

代理设计模式的原理： 使用一个代理将对象包装起来， 然后用该代理对象取代原始对象。 任何对原始对象的调用都要通过代理。 代理对象决定是否以及何时将方法调用转到原始对象上。 

动态代理类

```java
public class ArithmeticCalculatorLoggingProxy {

    // 要代理的对象
    private ArithmeticCalculator target=new ArithmeticCalculatorImpl();

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target){
        this.target=target;
    }

    public ArithmeticCalculator getLoggingProxy(){
        ArithmeticCalculator proxy=null;

        // 代理对象由哪一个类加载器负责加载
        ClassLoader loader=target.getClass().getClassLoader();

        // 代理对象的类型，即其中有哪些方法
        Class[] intefaces=new Class[]{ArithmeticCalculator.class};

        // 当调用代理对象其中的方法时，该执行的代码
        InvocationHandler h=new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke...");
                return 0;
            }
        };
        proxy= (ArithmeticCalculator) Proxy.newProxyInstance(loader,intefaces,h);
        return proxy;
    }
}
```

输出

```
直接调用ArithmeticCalculatorImpl类的add方法
result:12
调用由代理类中由Proxy的静态方法返回的ArithmeticCalculator对象的add方法
invoke...
result:0
```

可以看到代理类中写的invoke方法执行了。

接下来使用动态代理实现数学计算器中的日志功能（在invoke方法中添加日志，日志内容可以传入方法名及参数信息，所以日志可以动态变化）

```java
InvocationHandler h=new InvocationHandler() {
    /*
            proxy:正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
            method：正在被调用的方法
            args：调用方法时，传入的参数
             */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName=method.getName();
        // 日志
        System.out.println("The method "+methodName+" begins with "+ Arrays.asList(args));
        // 执行方法
        Object result=method.invoke(target,args);
        // 日志
        System.out.println("The method "+methodName+" ends with "+result);
        return result;
    }
};
```

输出

```
调用由代理类中由Proxy的静态方法返回的ArithmeticCalculator对象的add方法
The method add begins with [5, 7]
The method add ends with 12
result:12
```

> 开发中一般不直接使用动态代理，因为实现起来比较麻烦，可以用更方便的spring的aop实现

##### 动态代理的方式 

（1）基于接口实现动态代理： JDK 动态代理 

（2）基于继承实现动态代理： Cglib、 Javassist 动态代理 

### AOP 概述  

#### AOP 概述 

1、AOP(Aspect-Oriented Programming， 面向切面编程)： 是一种新的方法论， 是对传统 OOP(Object-Oriented Programming， 面向对象编程)的补充。 

2、AOP 编程操作的主要对象是切面(aspect)， 而切面模块化横切关注点。 

3、在应用 AOP 编程时， 仍然需要定义公共功能， 但可以明确的定义这个功能应用在哪里，以什么方式应用， 并且不必修改受影响的类。 这样一来横切关注点就被模块化到特殊的类里——这样的类我们通常称之为“切面”。 

4、AOP 的好处 

（1）每个事物逻辑位于一个位置， 代码不分散， 便于维护和升级 

（2）业务模块更简洁， 只包含核心业务代码 

（3）AOP 图解 

#### AOP 术语 

##### 横切关注点 

从每个方法中抽取出来的同一类非核心业务。 

##### 切面(Aspect) 

封装横切关注点信息的类， 每个关注点体现为一个通知方法。 

##### 通知(Advice) 

切面必须要完成的各个具体工作 。

##### 目标(Target) 

被通知的对象 

##### 代理(Proxy) 

向目标对象应用通知之后创建的代理对象 

##### 连接点(Joinpoint) 

横切关注点在程序代码中的具体体现， 对应程序执行的某个特定位置。 例如： 类某个方法调用前、 调用后、 方法捕获到异常后等。 

在应用程序中可以使用横纵两个坐标来定位一个具体的连接点 。

横坐标：各个模块中的可执行方法；

纵坐标：每个方法中的各个关注点，如方法开始、捕获异常、方法结束；

##### 切入点(pointcut) 

定位连接点的方式。 每个类的方法中都包含多个连接点， 所以连接点是类中客观存在的事物。 **如果把连接点看作数据库中的记录， 那么切入点就是查询条件**——AOP 可以通过切入点定位到特定的连接点。 切点通过 org.springframework.aop.Pointcut 接口进行描述， 它使用类和方法作为连接点的查询条件。 

#### AspectJ 

##### 简介 

AspectJ： Java 社区里最完整最流行的 AOP 框架。 

在 Spring2.0 以上版本中， 可以使用基于 AspectJ 注解或基于 XML 配置的 AOP。 

##### 在 Spring 中启用 AspectJ 注解支持 

1、导入 JAR 包 （可以使用maven）

2、引入 aop 名称空间 

3、配置 

当 Spring IOC 容器侦测到 bean 配置文件中的<aop:aspectj-autoproxy>元素时， 会自动为与 AspectJ 切面匹配的 bean 创建代理 

##### 用 AspectJ 注解声明切面 

1、要在 Spring 中声明 AspectJ 切面， 只需要在 IOC 容器中将切面声明为 bean 实例。 

2、当在 Spring IOC 容器中初始化 AspectJ 切面之后，Spring IOC 容器就会为那些与 AspectJ切面相匹配的 bean 创建代理。 

3、在 AspectJ 注解中，切面只是一个带有@Aspect 注解的 Java 类，它往往要包含很多通知。 

4、通知是标注有某种注解的简单的 Java 方法。 

5、AspectJ 支持 5 种类型的通知注解 

（1）@Before： 前置通知， 在方法执行之前执行 

（2）@After： 后置通知， 在方法执行之后执行 

（3）@AfterRunning： 返回通知， 在方法返回结果之后执行 

（4）@AfterThrowing： 异常通知， 在方法抛出异常之后执行 

（5）@Around： 环绕通知， 围绕着方法执行 

使用aop给数学计算器添加日志的步骤：

1、使用maven导入aop要用的包：spring-aop，spring-context，aspectjweaver

2、在配置文件中加入 `<aop:aspectj-autoproxy></aop:aspectj-autoproxy>`的配置

```xml
    <context:component-scan base-package="aopOverview.calculator_aop"></context:component-scan>

    <!--使AspectJ注解起作用，自动为匹配的类生成代理对象-->
    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
```

3、把横切关注点的代码抽象到切面的类中：切面首先是一个IOC中的bean，即加入@Component注解；切面还需要加入@Aspect注解；

4、在类中声明各种通知：声明一个方法；在方法前加入@Before等注解，并添加切入的方法；

```java
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins with "+args);
    }
}
```

### AOP 细节 

#### 切入点表达式 

##### 作用 

通过表达式的方式定位一个或多个具体的连接点。 

##### 语法细节 

1、切入点表达式的语法格式 

```
execution([权限修饰符] [返回值类型] [简单类名/全类名] [方法名]([参数列表]))
```

2、举例说明 

3、在 AspectJ 中， 切入点表达式可以通过 “&&”、 “||”、 “!”等操作符结合起来。 

##### 切入点表达式应用到实际的切面类中 

#### 当前连接点细节 

##### 概述 

切入点表达式通常都会是从宏观上定位一组方法，和具体某个通知的注解结合起来就能够确定对应的连接点。 那么就一个具体的连接点而言， 我们可能会关心这个连接点的一些具体信息， 例如： 当前连接点所在方法的方法名、 当前传入的参数值等等。 这些信息都封装在JoinPoint 接口的实例对象中。 

##### JoinPoint 

#### 通知 

##### 概述 

1、在具体的连接点上要执行的操作。 

2、一个切面可以包括一个或者多个通知。 

3、通知所使用的注解的值往往是切入点表达式。 

##### 前置通知 

前置通知： 在方法执行之前执行的通知 ，使用@Before 注解 。

```java
    // 声明该方法是一个前置通知，在目标方法开始之前执行
    @Before("execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins with "+args);
    
```

输出

```
The method add begins with [5, 7]
result:12
The method div begins with [8, 2]
result:4
```

##### 后置通知 

后置通知： 后置通知是在连接点完成之后执行的， 即连接点返回结果或者抛出异常的时候 ，使用@After 注解 

```java
    // 声明该方法是一个后置通知（无论是否发生异常），在目标方法开始之后执行
	@After("execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))")
    public  void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }
```

输出

```
The method add ends
result:12
The method div ends
result:4
```

##### 返回通知 

1、返回通知： 无论连接点是正常返回还是抛出异常， 后置通知都会执行。 如果只想在连接点返回的时候记录日志， 应使用返回通知代替后置通知。 

2、使用@AfterReturning 注解,在返回通知中访问连接点的返回值 

（1）在返回通知中， 只要将 returning 属性添加到@AfterReturning 注解中， 就可以访问连接点的返回值。 该属性的值即为用来传入返回值的参数名称 

（2）必须在通知方法的签名中添加一个同名参数。 在运行时 Spring AOP 会通过这个参数传递返回值 

（3）原始的切点表达式需要出现在 pointcut 属性中 

添加返回通知

```java
    // 声明该方法是一个返回通知，返回通知是可以访问到方法的返回值的
    @AfterReturning(value = "execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))",returning = "result")
    public  void afterReturnMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends with "+result);
    }
```

输出

```
The method add begins with [5, 7]
The method add ends
The method add ends with 12
result:12
The method div begins with [8, 2]
The method div ends
The method div ends with 4
result:4
The method div begins with [1000, 0]
The method div ends
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

抛出异常时返回通知将不执行，但是后置通知会执行

##### 异常通知 

1、异常通知： 只在连接点抛出异常时才执行异常通知 

2、将 throwing 属性添加到@AfterThrowing 注解中， 也可以访问连接点抛出的异常。Throwable 是所有错误和异常类的顶级父类， 所以在异常通知方法可以捕获到任何错误和异常 

3、如果只对某种特殊的异常类型感兴趣， 可以将参数声明为其他异常的参数类型。 然后通知就只在抛出这个类型及其子类的异常时才被执行 

添加异常通知

```java
    // 在目标方法出现异常时会执行的代码，可以访问到异常对象，且可以指定出现特定异常时执行通知代码
    @AfterThrowing(value = "execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))",throwing = "e")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception e){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" occurs exception: "+e);
    }
```

输出

```
The method div begins with [1000, 0]
The method div ends
The method div occurs exception: java.lang.ArithmeticException: / by zero
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

在异常通知中指定特定异常

```java
public void afterThrowingMethod(JoinPoint joinPoint, NullPointerException e)
```

输出

```
The method div begins with [1000, 0]
The method div ends
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

由于抛出的是算术异常，而指定的是空指针异常，所以异常通知不会执行。

##### 环绕通知 

1、环绕通知是所有通知类型中功能最为强大的， 能够全面地控制连接点， 甚至可以控制是否执行连接点。 

2、对于环绕通知来说， 连接点的参数类型必须是 ProceedingJoinPoint。 它是 JoinPoint 的子接口， 允许控制何时执行， 是否执行连接点。 

3、在环绕通知中需要明确调用 ProceedingJoinPoint 的 proceed()方法来执行被代理的方法。如果忘记这样做就会导致通知被执行了， 但目标方法没有被执行 

4、注意： 环绕通知的方法需要返回目标方法执行之后的结果， 即调用 joinPoint.proceed();的返回值， 否则会出现空指针异常。 

添加环绕通知

```java
@Component
@Aspect
public class LoggingAspect2 {
    @Around(value = "execution(public int aopOverview.calculator_aop.ArithmeticCalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        Object result=null;
        String methodName=joinPoint.getSignature().getName();

        try {
            // 前置通知
            System.out.println("The method "+ methodName+" begins with "+ Arrays.asList(joinPoint.getArgs()));
            result= joinPoint.proceed();
            // 返回通知
            System.out.println("The method "+methodName+" ends with "+result);
        } catch (Throwable throwable) {
            // 异常通知
            System.out.println("The method "+methodName+" occurs exception: "+throwable);
            throw new RuntimeException(throwable);
        }finally {
            // 后置通知
            System.out.println("The method "+methodName+" ends");
        }
        return result;
    }
}
```

输出

```
The method add begins with [5, 7]
The method add ends with 12
The method add ends
result:12
The method div begins with [1000, 0]
The method div occurs exception: java.lang.ArithmeticException: / by zero
The method div ends
Exception in thread "main" java.lang.RuntimeException: java.lang.ArithmeticException: / by zero
```

#### 重用切入点定义 

1、在编写 AspectJ 切面时， 可以直接在通知注解中书写切入点表达式。 但同一个切点表达式可能会在多个通知中重复出现。 

2、在 AspectJ 切面中， 可以通过@Pointcut 注解将一个切入点声明成简单的方法。 切入点的方法体通常是空的， 因为将切入点定义与应用程序逻辑混在一起是不合理的。 

3、切入点方法的访问控制符同时也控制着这个切入点的可见性。如果切入点要在多个切面中共用， 最好将它们集中在一个公共的类中。 在这种情况下， 它们必须被声明为 public。在引入这个切入点时，必须将类名也包括在内。如果类没有与这个切面放在同一个包中，还必须包含包名。 

4、其他通知可以通过方法名称引入该切入点 

声明切入点表达式，并将通知的切入点都使用切入点表达式来表示

```java
    // 定义一个方法，用于声明切入点表达式，一般地，该方法中不需要再添加其他的代码
    @Pointcut("execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int))")
    public void declareJoinPointExpression(){}

    // 声明该方法是一个前置通知，在目标方法开始之前执行
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+methodName+" begins with "+args);
    }

    // 声明该方法是一个后置通知（无论是否发生异常），在目标方法开始之后执行
    @After("declareJoinPointExpression()")
    public  void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends");
    }

    // 声明该方法是一个返回通知，返回通知是可以访问到方法的返回值的
    @AfterReturning(value = "declareJoinPointExpression()",returning = "result")
    public  void afterReturnMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" ends with "+result);
    }

    // 在目标方法出现异常时会执行的代码，可以访问到异常对象，且可以指定出现特定异常时执行通知代码
    @AfterThrowing(value = "declareJoinPointExpression()",throwing = "e")
    public void afterThrowingMethod(JoinPoint joinPoint, NullPointerException e){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("The method "+methodName+" occurs exception: "+e);
    }
```

输出

```
validate: [5, 7]
The method add begins with [5, 7]
The method add ends
The method add ends with 12
result:12
```

#### 指定切面的优先级 

1、在同一个连接点上应用不止一个切面时，除非明确指定，否则它们的优先级是不确定的。 

2、切面的优先级可以通过实现 Ordered 接口或利用@Order 注解指定。 

3、实现 Ordered 接口， getOrder()方法的返回值越小， 优先级越高。 

4、若使用@Order 注解， 序号出现在注解中 

验证参数的切面，@Order(1)

```java
@Order(1)
@Component
@Aspect
public class ValidationAspect {
    @Before("execution(public int aopOverview.calculator_aop.ArithmeticCalculator.*(int,int)))")
    public void validationMethod(JoinPoint joinPoint){
        System.out.println("validate: "+ Arrays.asList(joinPoint.getArgs()));
    }
}
```

添加日志的切面，@Order(2)

```java
@Order(2)
@Aspect
@Component
public class LoggingAspect {...}
```

输出

```
validate: [5, 7]
The method add begins with [5, 7]
The method add ends
The method add ends with 12
result:12
```

@Order中数字小的切面在前面执行



