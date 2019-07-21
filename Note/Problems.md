# Problems

### 快速注释多行代码

**Eclipse**

单行注释：

CTRL + /

当行取消注释（一样的）：

CTRL + /    

多行注释：

CTRL + SHIFT + /

多行取消注释（斜杠换成反斜杠）：

CTRL + SHIFT + \

**IDEA**

其他和eclipse相同，但是多行取消注释依然是CTRL + SHIFT + /；

### 正则表达式

[参考资料](https://juejin.im/post/5cb7c525e51d456e431ada43)

**Java中正则表达式的使用方法**

1、简单例子：

```java
public class Demo1 {
    public static void main(String[] args) {
        //字符串abc匹配正则表达式"...", 其中"."表示一个字符
        //"..."表示三个字符
        System.out.println("abc".matches("..."));

        System.out.println("abcd".matches("..."));
    }
}
//输出结果
true
false

```

2、

2、在`java.util.regex`包下有两个用于正则表达式的类, 一个是`Matcher`类, 另一个`Pattern`. Java官方文档中给出对这两个类的典型用法, 代码如下:

```java
public class Demo2 {
    public static void main(String[] args) {
        //[a-z]表示a~z之间的任何一个字符, {3}表示3个字符, 意思是匹配一个长度为3, 并且每个字符属于a~z的字符串
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("abc");
        System.out.println(m.matches());
    }
}
//输出结果
true
```
Pattern类(compile静态方法)表示正则表达式，而Marcher类(matcher方法)代表匹配结果；

Pattern可以理解为一个模式, 字符串需要与某种模式进行匹配. 比如Demo2中, 我们定义的模式是一个长度为3的字符串, 其中每个字符必须是a~z中的一个.

Matcher可以理解为模式匹配某个字符串后产生的结果. 字符串和某个模式匹配后可能会产生很多个结果, 这个会在后面的例子中讲解.

上面的三行代码可以简化为一行代码`System.out.println("abc".matches("[a-z]{3}"));`

3、字符个数的匹配

```java
.	Any character (may or may not match line terminators), 任意字符
X?	X, once or not at all       零个或一个
X*	X, zero or more times       零个或多个
X+	X, one or more times        一个或多个
X{n}	X, exactly n times          x出现n次
X{n,}	X, at least n times     x出现至少n次
X{n,m}	X, at least n but not more than m times 出现n~m次
```

4、字符的范围

用[]描述

```java
public class Demo3 {
    private static void p(Object o){
        System.out.println(o);
    }
    public static void main(String[] args) {
        //[abc]指abc中的其中一个字母
        p("a".matches("[abc]"));
        //[^abc]指除了abc之外的字符
        p("1".matches("[^abc]"));
        //a~z或A~Z的字符, 以下三个均是或的写法
        p("A".matches("[a-zA-Z]"));
        p("A".matches("[a-z|A-Z]"));
        p("A".matches("[a-z[A-Z]]"));
        //[A-Z&&[REQ]]指A~Z中并且属于REQ其中之一的字符
        p("R".matches("[A-Z&&[REQ]]"));
    }
}
//输出结果
全部为true

```

5、数字和字母的正则表达

> 这里重点介绍最不好理解的`\`. 在Java中的字符串中, 如果要用到特殊字符, 必须通过在前面加`\`进行转义.
>
> 如何在正则表达式中表示要匹配`\`呢, 答案为`"\\\\"`.

```java
public class Demo4 {
    private static void p(Object o){
        System.out.println(o);
    }

    public static void main(String[] args) {
        /**
         * \d	A digit: [0-9]          数字
         * \D	A non-digit: [^0-9]     非数字
         * \s	A whitespace character: [ \t\n\x0B\f\r] 空格
         * \S	A non-whitespace character: [^\s]       非空格
         * \w	A word character: [a-zA-Z_0-9]          数字字母和下划线
         * \W	A non-word character: [^\w]             非数字字母和下划线
         */
        // \\s{4}表示4个空白符
        p(" \n\r\t".matches("\\s{4}"));
        // \\S表示非空白符
        p("a".matches("\\S"));
        // \\w{3}表示数字字母和下划线
        p("a_8".matches("\\w{3}"));
        p("abc888&^%".matches("[a-z]{1,3}\\d+[%^&*]+"));
        // 匹配 \
        p("\\".matches("\\\\"));
    }
}
//输出结果
全部为true
```

上面的数字和字母正则表达式，都含有符号\，所以前面要再加个\进行转义；

6、字符串的边界处理

```java
public class Demo5 {
    private static void p(Object o){
        System.out.println(o);
    }

    public static void main(String[] args) {
        /**
         * ^	The beginning of a line 一个字符串的开始
         * $	The end of a line       字符串的结束
         * \b	A word boundary         一个单词的边界, 可以是空格, 换行符等
         */
        p("hello sir".matches("^h.*"));
        p("hello sir".matches(".*r$"));
        p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
        p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
    }
}

```

7、正则表达式规则比较复杂，可以直接上网搜索常见场景的正则表达式；

### 注解自动装配和属性赋值

[spring注解之自动装配和属性赋值](https://www.cnblogs.com/not-miss/p/10806162.html)

#### 自动装配

1、启用注解装配

在spring的context命名空间配置中的context:annotation-config元素。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd"
       default-init-method="init" default-destroy-method="destroy">
    <context:annotation-config/>
</beans>

```

2、@Autowired基本使用

默认优先按照类型去容器中找对应的组件:applicationContext.getBean(Apple.class) 找到就赋值；

```java
public class User{
	@AutoWired
	private Apple apple;
	//...
}
```

```xml
<bean id="user" class="xyz.totok.User"/>
<bean id="apple" class="xyz.totok.Apple"/>
```

如果找到多个相同类型的组件，将属性的名称作为组件的id去容器中找applicationContext.getBean("apple")

从@Autowired定义来看，该注解可修饰 构造器、方法、参数、属性、注解

（1）标注在方法上：根据方法的形参，从容器中查找

```java
@Component
public class Teacher {
    private Book book;

    @Autowired
　　//标注在方法，Spring容器创建当前对象，就会调用方法，完成赋值；
    //方法使用的参数，自定义类型的值从ioc容器中获取
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    @Override
    public String toString() {
        return "Teacher{" + "book=" + book + '}';
    }
}
```

（2）标注在构造器：默认调用无参构造器

```java
//默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Teacher {
    private Book book;

    //构造器要用的组件，都是从容器中获得
    @Autowired
    public Teacher (Book book){
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    @Override
    public String toString() {
        return "Teacher{" + "book=" + book + '}';
    }
}

//如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
```

（3）标注在参数中：根据参数组件值从容器中查找对应的组件

```java
@Component
public class Teacher {
    private Book book;

    //标注在形参上也是一样，都是从容器中获得public Teacher ( @Autowired Book book){
        this.book = book;
    }

    @Autowired
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    @Override
    public String toString() {
        return "Teacher{" + "book=" + book + '}';
    }
}
```

2、@Qualifier

多个bean符合装配条件使用@Qualifier

@Qualifier指定需要装配的组件的id，而不是使用属性名

```xml
<context:annotation-config/>
    <bean id="user" class="xyz.totok.User"/>
    <bean id="apple1" class="xyz.totok.Apple"/>
    <bean id="apple2" class="xyz.totok.Apple"/>

```
此时apple属性有两个bean都符合条件，会报错。解决方式如下

```java
public class User{
	@AutoWired(required=false)
	@Qualifier("apple1")
	private Apple apple;
	//...
}

```

这时会把apple1装配成功。

3、@Autowired(required=false)

使用required设置自动装配为可选的

因为 required=false，如果spring找不到对应的组件的话会赋空值进去；

```java
@Service
public class BookService {
　　
    @Autowired(required = false)//如果容器中没有BookDao组件的话， 则bookDao=null
    private BookDao bookDao;
    public void print(){
        System.out.println(bookDao);
    }
    @Override
    public String toString() {
        return "BookService{" + "bookDao=" + bookDao + '}';
    }
}
```

#### 属性赋值

使用@Value赋值：
  1.基本数值
  2.可以写SpEL； #{}
  3.可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）

```java
public class Person {

    @Value("高菲") //基本数值
    private String name;

    @Value("#{20-2}") //SpEL表达式 #{}
    private Integer age;

    @Value("${person.nickName}") //取出配置文件中的数据 ${}
    private String nickName;

　　下面代码是 setter/getter/toString方法
}
```

### Java中的文件路径

[java如何通过绝对路径和相对路径读取文件](https://blog.csdn.net/qq_39629343/article/details/80500820)

[文件路径./和../](https://blog.csdn.net/qq_20412595/article/details/82423764)

当我在写java的数据库连接时，希望通过使用文件的相对路径来读取信息，因为使用绝对路径时在代码移植之后就会出现问题，这不是一个好的方法

1、概念

绝对路径：在我们平时使用计算机时要找到需要的文件就必须知道文件的位置，而表示文件的位置的方式就是路径

相对路径：由这个文件所在的路径引起的跟其它文件（或文件夹）的路径关系

2、java通过绝对路径读取文件

文件路径:`D:\file\logon_initial.properties`

读取文件的代码：`prop.load(new FileInputStream("D:\\file\\logon_initial.properties"));`

需要注意的是绝对路径还要转义反斜杠

3、java通过src目录读取文件(以src为根目录)

文件路径: `D:\javacode\fileread\src\DB\logon_initial.properties`

读取文件的代码：  `prop.load(new FileInputStream("src/DB/logon_initial.properties"));`

4、java通过CLASSPATH路径来读取包内文件(bin目录)

通过这个方法可以用文件的相对路径来读取，比前两个方法更加可靠,需要注意的是要将`logon_initial.properties`和`DBConnection.class`处于同一个目录下，只要和当前类的的java源代码同一目录下即可，会自动加载到bin目录下。

1).绝对路径

```java
String path = DBConnect.class.getResource(“/DB/logon_initial.properties”).getPath();
```

2).通过类加载器来读取

```java
String path = 当前类名.class.getClassLoader().getResource("logon_initial.properties").getPath();
```

切记是把要读取的文件放在和当前类的java源代码处于同一个包内(src下的目录下)

5、文件路径./和../

学习了  ”/  " 、“  ./ “ 、 ”../“的区别在此记录下

/ ：表示当前路径的根路径。

./ ：表示当前路径。

../ ：表示父级路径，当前路径所在的上一级路径。 

6、/和\的区别

/是linux和http路径里面用的（/，斜杆）

\是windows的路径分隔符  （\，反斜杆，可以做转义字符）

如果表示windows中路径，两个都可以用；如果表示网路文件路径，则必须用/；

### Java中的lambda表达式

#### lambda的概念

lambda可以将“一块代码”赋给一个Java变量，并且做了很多简化；

```java
myInterface=(s)-> System.out.println(s);
```

而这个被赋值的java变量是一个接口，在Java 8里面，所有的Lambda的类型都是一个接口，而Lambda表达式本身，也就是”那段代码“，需要是这个接口的实现。Lambda表达式本身就是一个接口的实现。

```java
public static void main(String[] args){
    MyInterface myInterface=(s)-> System.out.println(s);
    myInterface.doSomething("Hello World");
}
```

```java
public interface MyInterface {
    public void doSomething(String s);
}
```

这种只有一个接口函数需要被实现的接口类型，我们叫它”函数式接口“。为了避免后来的人在这个接口中增加接口函数导致其有多个接口函数需要被实现，变成"非函数接口”，我们可以在这个上面加上一个声明@FunctionalInterface, 这样别人就无法在里面添加新的接口函数了：

#### lambda的作用

- 最直观的作用就是使得代码变得异常简洁。对于函数式接口，可以将接口的实现以非常简洁的形式实现。
- 可以直接把Lambda作为参数传给函数, 而传统的Java必须有明确的接口实现的定义，初始化才行。
- Lambda结合FunctionalInterface Lib, forEach, stream()，method reference等新特性可以使代码变的更加简洁！

#### lambda写法的简化

```java
/**
 * 1、直接用Java 8函数式接口包里的Predicate<T>和Consumer<T>就可以，
 * 不需要两个接口了，Predicate接口包含验证方法，Consumer接口包含执行方法
 * 2、用Iterable.forEach()取代foreach loop
 */

public class Main {
    public static void main(String[] args){
        List<Person> list = Arrays.asList(
                new Person("zhou", "jielun", 35),
                new Person("zhou", "yunfa", 55),
                new Person("deng", "ziqi", 27)
        );
        checkAndExecute(list,(p)->p.getFirstName().startsWith("z"),(p)-> System.out.println(p.getFirstName()+" "+p.getLastName()));
    }
    public static void checkAndExecute(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer){
        list.forEach((p)->{if(predicate.test(p))consumer.accept(p);});
    }
}
```

### 控制台乱码

1、vscode控制台乱码，是编码的问题；vscode使用的是cmd控制台，所以需要从cmd控制台入手；

在cmd下使用chcp 65001切换编码到utf-8，然后将字体改为Lucia Console, 然后确定即可；

2、后来发现现在的vscode已经用的是powershell了，在注册表中找到HKEY_CURRENT_USER\Console\%SystemRoot%_System32_WindowsPowerShell_v1.0_powershell.exe和HKEY_CURRENT_USER\Console\%SystemRoot%_SysWOW64_WindowsPowerShell_v1.0_powershell.exe，然后在两个文件夹下新建DWORD值：名称设为CodePage，数值设为十进制下的65001，然后重启powershell即可；

### Idea和Eclipse的项目结构

### Java IO

#### Scanner类

可以接收用户的控制台输入

```java
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
```

主要使用hasNextXXX方法和nextXXX方法；

next():只读取输入直到空格。它不能读两个由空格或符号隔开的单词。此外，next()在读取输入后将光标放在同一行中。(next()只读空格之前的数据,并且光标指向本行)

nextLine():读取输入，包括单词之间的空格和除回车以外的所有符号(即。它读到行尾)。读取输入后，nextLine()将光标定位在下一行。

#### 输入输出流

四个最重要的抽象类

|        | 输入流      | 输出流       |
| ------ | ----------- | ------------ |
| 字符流 | Reader      | Writer       |
| 字节流 | InputStream | OutputStream |

（1）字符流

字符流有两个抽象类：**Writer**和**Reader**类。 其对应子类**FileWriter**和**FileReader**可实现文件的读写操作。 **BufferedWriter**和**BufferedReader**能够提供缓冲区功能，用以提高效率。

一般来说，我们主要用字符流的情况是读写文件，大部分也是**文本文件**，比如.txt后缀的。

（2）字节流

字节流也有两个抽象类：**InputStream**和**OutputStream**类。 其对应子类有**FileInputStream**和**FileOutputStream**实现文件读写操作。 **BufferedInputStream**和**BufferedOutputStream**提供缓冲区功能

字节流也能对文本进行读取，但是它的主要使用的场景是读取**无法直接获取文本信息的二进制文件**，比如音乐文件、视频文件、图片文件等等。

（3）用户输入

用户输入是字节流，我们一般将其转换为字符流处理；

**InputStreamReader** ：是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。

```java
public class Main{
    public static void main(String[] args){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // 将用户输入全部以字符串形式存储
        String s1=br.readLine();
        // 对于一行多组数据，使用split(" ")进行分割，得到字符串数组
        String[] s2=br.readLine().split(" ");
        // 如果实际需要整型数字，将字符串用parseInt进行转换
        int n=Integer.parseInt(s1);
        // valueOf方法则转换为Integer类型
        Integer n=Integer.valueOf(s1);
    }
}
```

以上代码用Scanner类来处理

```java
// 直接用nextInt方法接收整型数字
	Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] pi = new int[n+1];
    for(int i=1; i<=n; i++){
        pi[i] = scanner.nextInt();
    }
    scanner.close();
```

### vscode找不到主类的问题

Run VS Code command *"Java: Force Java compilation"* to force the language server to rebuild the current project.

### linux yum

基于rpm的软件包管理器。将所有软件包放到官方服务器上，当进行yum在线安装时，可以自动解决依赖性问题。

#### yum的基本使用方法

```
yum install package 安装程序package

yum groupinstall package 安装程序组

yum update package 更新程序package

yum upgrade package 升级程序package

yum remove package 卸载程序package
```

```
 yum list
 #查询所有可用的软件包列表
 yum search 关键字
 #搜索服务器上所有和关键字相关的包
 yum -y install 包名
 #安装包 -y 自动回答yes
 yum -y update 包名
 #升级包
 yum -y remove 包名
 #卸载包
```



#### 软件包的分类

（1）源码包

优点

- 开源，如果有足够能力，可以修改源代码
- 可以自由选择所需的功能
- 软件四编译安装，更加适合自己的系统，更加稳定也效率更高
- 卸载方便

缺点

- 安装过程步骤较多，尤其安装较大的软件集合，容易出现错误
- 编译过程时间较长，安装比二进制安装时间长
- 因为是编译安装，安装过程中一旦报错新手很难解决

（2）二进制包

优点

- 包管理系统简单，只通过几个命令就可以实现包的安装、升级、查询和卸载
- 安装速度比源码包安装快得多

缺点

- 经过变异，不再可以看到源代码
- 功能选择不如源码包灵活
- 依赖性

#### 安装位置

用yum安装，实质上是用RPM安装，所以RPM查询信息的指令都可用。

rpm有两个参数-l和-c可以帮助我们查看具体的安装路径：

-l 显示软件包中的文件列表

-c 显示配置文件列表

-a 查询所安装的所有rpm包

```
rpm -ql 包名
rpm -qa | grep 包名
```

一般来说，RPM默认安装路径如下：

| Directory      | **Contents of Directory**                 |
| -------------- | ----------------------------------------- |
| /etc           | 一些配置文件的目录，例如/etc/init.d/mysql |
| /usr/bin       | 一些可执行文件                            |
| /usr/lib       | 一些程序使用的动态函数库                  |
| /usr/share/doc | 一些基本的软件使用手册与帮助文档          |
| /usr/share/man | 一些man page文件                          |

### Java 日志

[著名的Log4j是怎么来的](https://zhuanlan.zhihu.com/p/50564627)

### Matplotlib

[Matplotlib tutorial](https://github.com/rougier/matplotlib-tutorial)

Matplotlib 可能是 Python 2D-绘图领域使用最广泛的套件。

#### pylab

pylab 是 matplotlib 面向对象绘图库的一个接口。它的语法和 Matlab 十分相近。也就是说，它主要的绘图命令和 Matlab 对应的命令有相似的参数。

#### 初级绘制

先尝试用默认配置在同一张图上绘制正弦和余弦函数图像，然后逐步美化它。

绘制需要两个包：numpy计算包和matploylib.pylab包

> python包的安装：使用pip包管理工具

设置项

1、整张图的格式

```
plt.figure(figsize=(10,6), dpi=80)
```

2、线条格式

```
plt.plot(X, C, color="blue", linewidth=2.5, linestyle="-")
plt.plot(X, S, color="red",  linewidth=2.5, linestyle="-")
```

3、刻度范围

```
plt.xlim(X.min()*1.1, X.max()*1.1)
plt.ylim(C.min()*1.1, C.max()*1.1)
```

4、刻度显示

```
plt.xticks( [-np.pi, -np.pi/2, 0, np.pi/2, np.pi])
plt.yticks([-1, 0, +1])
```

刻度的别名表示

```
plt.xticks([-np.pi, -np.pi/2, 0, np.pi/2, np.pi],
       [r'$-\pi$', r'$-\pi/2$', r'$0$', r'$+\pi/2$', r'$+\pi$'])

plt.yticks([-1, 0, +1],
       [r'$-1$', r'$0$', r'$+1$'])
```

5、坐标轴变更 spines

```
ax = plt.gca()
ax.spines['right'].set_color('none')
ax.spines['top'].set_color('none')
ax.xaxis.set_ticks_position('bottom')
ax.spines['bottom'].set_position(('data',0))
ax.yaxis.set_ticks_position('left')
ax.spines['left'].set_position(('data',0))
```

6、添加图例

```
plt.plot(X, C, color="blue", linewidth=2.5, linestyle="-", label="cosine")
plt.plot(X, S, color="red",  linewidth=2.5, linestyle="-", label="sine")

plt.legend(loc='upper left', frameon=False)
```

7、注释某些点

```
t = 2*np.pi/3
plt.plot([t,t],[0,np.cos(t)], color ='blue', linewidth=1.5, linestyle="--")
plt.scatter([t,],[np.cos(t),], 50, color ='blue')

plt.annotate(r'$\sin(\frac{2\pi}{3})=\frac{\sqrt{3}}{2}$',
             xy=(t, np.sin(t)), xycoords='data',
             xytext=(+10, +30), textcoords='offset points', fontsize=16,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))

plt.plot([t,t],[0,np.sin(t)], color ='red', linewidth=1.5, linestyle="--")
plt.scatter([t,],[np.sin(t),], 50, color ='red')

plt.annotate(r'$\cos(\frac{2\pi}{3})=-\frac{1}{2}$',
             xy=(t, np.cos(t)), xycoords='data',
             xytext=(-90, -50), textcoords='offset points', fontsize=16,
             arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))
```

8、刻度显示在图层上面

```
for label in ax.get_xticklabels() + ax.get_yticklabels():
    label.set_fontsize(16)
    label.set_bbox(dict(facecolor='white', edgecolor='None', alpha=0.65 ))
```

### Tomcat

#### 什么是Tomcat

Tomcat简单的说就是一个运行JAVA的网络服务器，底层是Socket的一个程序，它也是JSP和Serlvet的一个容器。

#### 为什么我们需要用到Tomcat

如果你学过html，css，你会知道你写的页面只能自己访问，别人不能远程访问你写的页面，Tomcat就是提供能够让别人访问自己写的页面的一个程序

![img](https://user-gold-cdn.xitu.io/2018/2/3/1615bba48d71bc74?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

#### Tomcat下载

[官网下载地址](https://tomcat.apache.org/download-90.cgi)

下载二进制文件中的Core。

#### 配置Tomcat

运行Tomcat需要JDK的支持【Tomcat会通过JAVA_HOME找到所需要的JDK】。

- 新建JAVA_HOME环境变量【路径是JDK的主目录】

- 进入Tomcat目录下的bin中启动startup.bat，如果最后列出Server startup in xxxms，说明启动成功

  如果startup.bat一闪而过，在cmd窗口执行startup.bat，来看错误信息；

- 在浏览器地址栏输入http://localhost:8080,如果能够出现Tomcat页面，说明配置成功了！

注意：如果在使用Tomcat时出现了Error deploying web application directory web222,很大原因就是jdk和tomcat的版本不匹配。目前，jdk8不能匹配tomcat7.0，所以要降低jdk版本【换成JDK7】

------

当然也有可能不是一帆风顺能够直接启动Tomcat，不能正常启动Tomcat会有以下情况

1. JAVA_HOME配置错误
2. 端口被占用了
   - 第一种方法：在cmd输入netstat -anb查看谁占用了该端口【Tomcat默认的是8080】,在进程中关闭它
   - 第二种方法：主动改变tomcat的端口, 到tomcat主目录下的conf/server.xml文件中修改,把8080端口改成是8088或者是其他的‘

------

#### 相关术语介绍



![img](https://user-gold-cdn.xitu.io/2018/2/3/1615bba48e0171fe?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)



------

#### tomcat结构目录



![img](https://user-gold-cdn.xitu.io/2018/2/3/1615bba48fc31e99?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)



**目录的简单介绍**

1、bin：启动和关闭tomcat的bat文件

2、conf：配置文件

（1）`server.xml`该文件用于配置server相关的信息，比如tomcat启动的端口号，配置主机(Host)

（2）`web.xml`文件配置与web应用（web应用相当于一个web站点）

（3）`tomcat-user.xml`配置用户名密码和相关权限.

3、lib：该目录放置运行tomcat运行需要的jar包

4、logs：存放日志，当我们需要查看日志的时候，可以查询信息

5、webapps：放置我们的web应用

（1）ROOT目录：是你安装好tomcat并启动后访问localhost:8080时的页面项目。

（2）manager目录：在访问localhost:8080的页面上有很多链接，其中有一个manager的链接，点击之后打开的页面就是manager项目的页面，Manager页面可以管理其它发布的项目，如examaples，也可以管理你以后发布的项目，在它的页面上可以对所有的被管理项目进行启动、停止、重启操作。

> manager链接默认是不能打开的，需要设置使用者的用户名和密码，在tomcat的conf文件夹的tomcat-users.xml文件中，添加一个用户名和密码，如下

```xml
<role rolename="manager"/>
<role rolename="manager-gui"/>
<user username="admin" password="admin" roles="manager,manager-gui"/>
```

> 其中manager-gui是必须的，其他的参数的值可以任意命名。

（3）examples目录：在localhost:8080页面上点击examples链接，打开的就是examples目录的东西。

6、work工作目录：该目录用于存放jsp被访问后生成对应的server文件和.class文件

**webapps目录的详细说明**

在webapps中建立了web1目录，下面放置我们的html文件，jsp文件，图片等等，则web1就被当做web应用管理起来【tomcat6.0以后的版本才支持】

例子：在webapps下创建一个web站点，在web站点下创建一个html文件，访问html文件

web站点的目录是有规范的

![img](https://user-gold-cdn.xitu.io/2018/2/3/1615bba507fd704f?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)



为什么要这样设置web站点目录呢？

- 需求：我有多个html文件，想把其中的一个html文件作为我web站点的首页。
- 如果没有WEB-INF目录下的web.xml文件支持，是无法解决我的需求的
- 这个规范是约定熟成的。

下面将web站点下的helloword2.xml文件作为站点的首页

- 新建一个WEB-INF目录

- 在WEB-INF目录下创建一个web.xml

- web.xml我们不可能会写，所以可以在webapps目录下其他的站点中抄一份过来【复制ROOT/WEB-INF/web.xml的文件到自己的站点中】
- 在web.xml中添加以下代码

```
	  <welcome-file-list>
	        <welcome-file>helloword2.html</welcome-file>
	  </welcome-file-list>
```

- 访问web站点【helloword2.html已经是web站点的首页了，所以不需要指定资源访问了】

#### 配置虚拟目录

**为什么需要配置虚拟目录？**

- 如果把所有web站点的目录都放在webapps下，可能导致磁盘空间不够用，也不利于对web站点目录的管理【如果存在非常多的web站点目录】
- 把web站点的目录分散到其他磁盘管理就需要配置虚拟目录【默认情况下，只有webapps下的目录才能被Tomcat自动管理成一个web站点】
- 把web应用所在目录交给web服务器管理，这个过程称之为虚拟目录的映射

------

**配置虚拟目录方法一：**

- 在其他盘符下创建一个web站点目录，并创建WEB-INF目录和一个html文件。

- 找到Tomcat目录下/conf/server.xml文件

- 在server.xml中的节点下添加如下代码。path表示的是访问时输入的web项目名，docBase表示的是站点目录的绝对路径

```
		<Context path="/web1" docBase="D:\web1"/>
```

- 访问配置好的web站点

------

**配置虚拟目录方法二：**

- 进入到conf\Catalina\localhost文件下，创建一个xml文件，该文件的名字就是站点的名字。
- xml文件的代码如下，docBase是你web站点的绝对路径

```
<?xml version="1.0" encoding="UTF-8"?> 
<Context 
    docBase="D:\web1" 
    reloadable="true"> 
</Context> 
复制代码
```

- 访问web站点下的html资源

------

#### 配置临时域名

访问Tomcat服务器有好几种方式

- 使用localhost域名访问【localhost代表本机】
- 使用ip地址127.0.0.1访问【该ip地址也是本机】
- 使用机器名称访问【只限用于本机上或者局域网】
- 使用本机IP地址访问【在cmd中输入ipconfig可以查询到本机IP地址】
- 还可以为机器配置临时域名

**配置临时域名步骤**

- 打开到C:\Windows\System32\drivers\etc下，找到hosts文件

- 在hosts文件下配置临时域名

127.0.0.1 localhost

127.0.0.1 tempRealm

#### 设置虚拟主机

**什么是虚拟主机？**

多个不同域名的网站共存于一个Tomcat中

**为什么需要用到虚拟主机？**

例子：我现在开发了4个网站，有4个域名。如果我不配置虚拟主机，一个Tomcat服务器运行一个网站，我就需要4台电脑才能把4个网站运行起来。

**配置虚拟主机的步骤**

- 在tomcat的server.xml文件中添加主机名

```
	  <Host name="virtualRealm" appBase="D:\web1">
					<Context path="/web1" docBase="D:\web1"/>
	  </Host>
```

- 访问虚拟主机下的web站点

  访问virtualRealm:8080/web1/1.html

#### Tomcat体系结构



![img](https://user-gold-cdn.xitu.io/2018/2/3/1615bba5a9c6e958?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)



------

#### 浏览器访问WEB资源的流程图



![img](https://user-gold-cdn.xitu.io/2018/2/3/1615bba5b61538e2?imageView2/0/w/1280/h/960/format/webp/ignore-error/1)

#### IDE自带的Tomcat

Idea中的tomcat位置：

Eclipse中的tomcat位置：

### CMD操作

netstat 查看网络状态

### Idea

#### Idea工程结构

![idea工程结构 <https://segmentfault.com/q/1010000011603740>](https://segmentfault.com/img/bVWQV3?w=315&h=421)

- source 存放源代码
- resource 存放资源文件 properties/XML等等
- 有点的代表 java package
- 没点的是普通文件夹

在IDEA的Project Structure中对Module的开发目录进行文件夹分类，说明了不同性质的内容放在哪里。注意，这些不同内容的标记代表了一个标准Java工程的各项内容，IntelliJ就是根据这些标记来识别一个Java工程的各项内容的，比如，它会用javac去编译标记为Sources的源码，打包的时候会把标记为Resources的资源拷贝到jar包中，并且忽略标记为Exluded的内容。

**1. Source roots (or source folders)**

通过将文件夹加入这种类别，来告诉IntelliJ IDEA，这个文件夹和它的子文件夹中包含源码，在构建工程时，需要作为一部分被编译进去。

**2. Test source roots (or test source folders; shown as rootTest)**

这个类型的文件夹也用于存放源码，不过是测试的源码（比如单元测试）。test source 文件夹可以帮助你将测试代码和产品代码分离开。最终这些文件不会打包到jar/war包里面。

**3. Resource roots**

该类文件夹用于存放你的应用中需要用到的资源文件（如：图片、xml或者properties配置文件等）。

在构建过程中，resources文件夹中的内容均会按照原文件的样子被复制到输出文件夹。和sources文件夹一样，你可以定制你的resources文件夹的结构。你也可以指定你的resources文件夹中的文件被拷贝到输出文件的哪个文件夹中。

ps：默认情况下，工程编译后，resources中的文件和文件夹会被放置在和源码编译后相同的文件夹中，所以如果在源码中以相对路径读取resources中的配置文件时，可认为src中的java文件夹和resources为同一个根目录。

**4. Test resource roots**

（只有在java模式中可以使用）用于存放测试源码中关联的资源文件。除此之外，和resource文件夹没有区别。

### Cookie

#### Cookie简介

Cookie实际上是一小段的文本信息，它是服务器颁发给客户端浏览器的确认用户身份的“通行证”。

Cookie实际上是一小段的文本信息。 客户端请求服务器，如果服务器需要记录该用户状态，就使用response向客户端浏览器颁发一个Cookie。 客户端浏览器会把Cookie保存起来。 当浏览器再请求该网站时，浏览器把请求的网址连同该Cookie一同提交给服务器。 服务器检查该Cookie，以此来辨认用户状态。 服务器还可以根据需要修改Cookie的内容。

#### Cookie机制

1. 用户使用浏览器访问一个支持Cookie的网站的时候，用户会提供包括用户名在内的个人信息并且提交至服务器；
2. 服务器在向客户端回传相应的超文本的同时也会发回这些个人信息，当然这些信息并不是存放在HTTP响应体 （Response Body)中的，而是存放于HTTP响应头(Response Header)
3. 客户端浏览器接收到来自服务器的响应之后，浏览器会将这些信息存放在一个统一的位置。 
4. 客户端再次向服务器发送请求的时候，都会把相应的Cookie再次发回至服务器。 而这次，Cookie信息则存放在HTTP请求头(equest Header)了。

#### HTTP的Cookie机制

Web应用程序是使用HTTP协议传输数据的。HTTP协议是无状态的协议。 一旦数据交换完毕，客户端与服务器端的连接就会关闭，再次交换数据需要建立新的连接。 这就意味着服务器无法从连接上跟踪会话。Cookie就是这样的一种机制。它可以弥补HTTP协议无状态的不足。 在Session出现之前，基本上所有的网站都采用Cookie来跟踪会话。

#### Set-Cookie和Cookie

当服务器返回给客户端一个Http响应信息时，其中如果包含Set-Cookie这个头部，说明：

1. 指示客户端建立一个cookie
2. 在后续的Http请求中自动发送这个cookie到服务器端，直到这个cookie过期。
3. 如果cookie的生存时间是整个会话期间的话，那么浏览器会将 cookie 保存在内存中， 浏览器关闭时就会自动清除这个cookie。
4. 如果将 cookie 保存在客户端的硬盘中，浏览器关闭的话，该 cookie 也不会被清除， 下次打开浏览器访问对应网站时，这个cookie就会自动再次发送到服务器端。

#### Cookie的不可跨域名性

Cookie在客户端是由浏览器来管理的。 浏览器能够保证Google只会操作Google的Cookie而不会操作Baidu的Cookie，从而保证用户的隐私安全。 浏览器判断一个网站是否能操作另一个网站Cookie的依据是域名。

### Maven

#### Maven仓库

![Maven仓库图片](https://mmbiz.qpic.cn/mmbiz_jpg/6mychickmupVog09YB8EAqIxKEgMwDBPnYoSiahL2m4GWNVoMXRjjNx5VnmSXs9ibZJOEia3URibWEoadQNX1AVhHmQ/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

Maven的配置文件：settings.xml

本地仓库路径配置：

```
<localRepository>本地路径</localRepository>
```

私服，就是公司内部局域网的一台服务器而已，私服中存储了本公司的内部专用的jar，还充当了中央仓库的镜像。

中央仓库：该仓库存储了互联网上的jar，由Maven团队来维护，地址是：http://repo1.maven.org/maven2/。

#### 依赖的使用

jar的查找坐标：groupId、artifactId、version。

version分为开发版本（Snapshot）和发布版本（Release）。

A服务依赖于B服务，A和B同时开发，在开发过程中B发布的版本标志为Snapshot版本，A进行依赖的时候选择Snapshot版本，那么每次B发布的话，会在私服仓库中，形成带有时间戳的Snapshot版本，而A构建的时候会自动下载B最新时间戳的Snapshot版本。

a.如果B不用SNAPSHOT，而是每次更新后都使用一个稳定的版本，那版本号就会升得太快，每天一升甚至每个小时一升，这就是对版本号的滥用。

b.如果B不用SNAPSHOT, 但一直使用一个单一的[Release版本](https://www.baidu.com/s?wd=Release版本&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)号，那当B更新后，A可能并不会接受到更新。因为A所使用的repository一般不会频繁更新release版本的缓存（即本地repository)，所以B以不换版本号的方式更新后，A在拿B时发现本地已有这个版本，就不会去远程Repository下载最新的B

c.正式环境中不得使用snapshot版本的库。 比如说，今天你依赖某个snapshot版本的第三方库成功构建了自己的应用，明天再构建时可能就会失败，因为今晚第三方可能已经更新了它的snapshot库。你再次构建时，Maven会去远程repository下载snapshot的最新版本，你构建时用的库就是新的jar文件了，这时正确性就很难保证了。

#### 依赖冲突

工程中需要引入A、B，而A依赖1.0版本的C，B依赖2.0版本的C，那么应该如何确保引入高版本的C呢？

解决方法：直接使用显式依赖指定C的版本

**依赖传递**

如果A依赖B，B依赖C，那么引入A，意味着B和C都会被引入。

**最近依赖策略**

如果一个项目依赖相同的groupId、artifactId的多个版本，那么在依赖树（mvn dependency:tree）中离项目最近的那个版本将会被使用。

#### Maven规范化目录结构

src/main下内容最终会打包到Jar/War中，而src/test下是测试内容，并不会打包进去。

src/main/resources中的资源文件会COPY至目标目录，这是Maven的默认生命周期中的一个规定动作。（想一想，hibernate/mybatis的映射XML需要放入resources下，而不能在放在其他地方了）

#### Maven的生命周期

clean;validate;compile;test;package;verify;install;site;deploy;

执行后面的命令时，前面的命令自动得到执行。

**常用命令：**

clean：有问题，多清理！

package：打成Jar or War包，会自动进行clean+compile

install：将本地工程Jar上传到本地仓库

deploy：上传到私服

#### 关于scope依赖范围

Maven的生命周期存在编译、测试、运行这些过程，那么显然有些依赖只用于测试，比如**junit**；有些依赖编译用不到，只有运行的时候才能用到，比如**mysql的驱动包**在编译期就用不到（**编译期用的是JDBC接口**），而是在运行时用到的；还有些依赖，编译期要用到，而运行期不需要提供，因为有些容器已经提供了，比如**servlet-api**在tomcat中已经提供了，我们只需要的是编译期提供而已。

compile：默认的scope，运行期有效，需要打入包中。

provided：编译期有效，运行期不需要提供，不会打入包中。

runtime：编译不需要，在运行期有效，需要导入包中。（接口与实现分离）

test：测试需要，不会打入包中。

system：非本地仓库引入、存在系统的某个路径下的jar。（一般不使用）

### Wireshark

#### NPcap

适用于Windows的数据包捕获库

#### 本地连接

本地连接（local connection）是指电脑中不同网络创建的链接，安装 Windows 时，将检测网络适配器，而且将创建本地连接。

#### 网络适配器

又称网卡，英文名称有NIC、network adapter。是一块被设计用来允许计算机在计算机网络上进行通讯的计算机硬件。由于其拥有MAC地址，因此属于OSI模型的第1层。它使得用户可以通过电缆或无线相互连接。每一个网卡都有一个被称为MAC地址的独一无二的48位串行号，它被写在卡上的一块ROM中。

#### 抓包过滤器

抓包的时候在选项中设置，可以限制只抓取指定的包；

1、语法说明

（1）BPF语法：基于libpcap/wincap库；

（2）类型Type：host、net和port；

（3）方向Dir：src、dst；

（4）协议Proto：ether、ip、tcp、udp、http、ftp；

（5）逻辑运算符：&& 与、||或和！非；

2、举例说明

（1）src host 192.168.1.1&&dst port 80：抓取源地址为192.168.1.1，目的为80端口的流量

（2）host 192.168.1.1||host 192.168.1.2：抓取192.168.1.1和192.168.1.2的流量

（3）!broadcast：不要抓取广播包

3、功能总结

（1）过滤MAC地址：ether src host 00:88:ca:86:f8:0d

（2）过滤ip地址

（3）过滤端口：port 80

（4）过滤协议：arp、icmp

（5）综合过滤 

#### 显示过滤器

对已抓取的包进行过滤，只显示指定的包；

1、语法说明

（1）比较操作符：大于、小于、不等于、大于等于、小于等于

（2）逻辑操作符：and、or、xor和not

（3）IP地址：ip.addr、ip.src和ip.dst

（4）端口过滤：tcp.port、tcp.srcport、tcp.dstport、tcp.flag.syn、tcp.flag.ack

（5）协议过滤：arp、ip、icmp、udp、tcp、bootp、dns

2、功能总结

（1）过滤ip地址 ip.addr==192.168.1.1

（2）过滤端口 tcp.port==80

（3）过滤协议 arp

（4）综合过滤

#### 数据流追踪

1、功能

将TCP、UDP、SSL等数据流进行重组并完整呈现出来；

2、路径

Analyze->Follow TCP stream 分析-跟踪TCP流

#### 专家信息

1、功能

可以对数据包中特定状态进行警告说明：错误、警告、注意和对话；

2、路径

Analyze->Expert Infos

#### 统计摘要

 1、功能

对抓取的数据包进行全局统计

2、路径

Statistics->Summary

### 计算机网络

#### 分类的IP地址

1、IP地址分为网络号和主机号两部分。

2、Internet设计者保留了IPv4地址空间的一部份供专用地址使用,专用地址空间中的IPv4地址叫专用地址,这些地址永远不会被当做公用地址来分配,所以专用地址永远不会与公用地址重复。

3、A类、B类和C类的网络号字段分别为1,2和3个字长。

A类：网络号码范围是 0.0.0.0---127.0.0.0，保留地址10.0.0.0-10.255.255.255

B类：网络号码范围是128.0.0.0--191.254.0.0，保留地址172.16.0.0-172.31.255.255

C类：网络号码范围是192.0.0.0--223.254.254.0，保留地址192.168.0.0-192.168.255.255

#### 内网

内网也就是局域网，内网的计算机以NAT（网络地址转换）协议，通过一个公共的网关访问Internet。

#### NAT

NAT（Network Address Translation，网络地址转换），它实现内网的IP地址与公网的地址之间的相互转换，将大量的内网IP地址转换为一个或少量的公网IP地址，减少对公网IP地址的占用。

使用NAT协议，局域网内的计算机可以访问Internet上的计算机，但Internet上的计算机无法访问局域网内的计算机。

#### 内网穿透

即NAT穿透，采用端口映射，让外网的电脑找到处于内网的电脑。

#### netstat命令

netstat 命令用于显示与 IP 、TCP 、UDP 和 ICMP 协议相关的统计数据，一般用于检验本机各端口的网络连接情况，可以使用 netstat 命令查看电脑中的端口。

-a : 显示所有活动的 tcp 连接，以及计算机监听的 tcp 和 udp 端口。

-e : 显示以太网发送和接收的字节数、数字包数等。

-n : 只以数字形式显示所有活动的 tcp 连接的地址和端口号。

-o : 显示活动的 tcp 连接并包括每个连接的进程 id。

-s : 按协议显示各种连接的统计信息，包括端口号。

#### 端口映射

端口映射是NAT的一种，功能是把在公网的地址转翻译成私有地址。端口映射就是将外网主机的IP地址的一个端口映射到内网中一台机器，提供相应的服务。当用户访问该IP的这个端口时，服务器自动将请求映射到对应局域网内部的机器上。端口映射有动态和静态之分。

#### ARP协议

即地址解析协议，是根据IP地址获取MAC地址的一个网络层协议。

ARP首先会发起一个请求数据包，数据包的首部包含了目标主机的IP地址，然后这个数据包会在链路层进行再次包装，生成以太网数据包，最终由以太网广播给子网内的所有主机，每一台主机都会接收到这个数据包，并取出标头里的IP地址，然后和自己的IP地址进行比较，如果相同就返回自己的MAC地址，如果不同就丢弃该数据包。ARP接收返回消息，以此确定目标机的MAC地址；与此同时，ARP还会将返回的MAC地址与对应的IP地址存入本机ARP缓存中并保留一定时间，下次请求时直接查询ARP缓存以节约资源。cmd输入 arp -a 就可以查询本机缓存的ARP数据。

#### 数据链路层-帧

链路层定义了主机的身份，即MAC地址。链路层的主要工作就是对电信号进行分组并形成具有特定意义的数据帧，然后以广播的形式通过物理介质发送给接收方。

数据在数据链路层分组打包；整个数据帧由首部、数据和尾部三部分组成，首部固定为14个字节，包含了目标MAC地址、源MAC地址和类型；数据最短为46个字节，最长为1500个字节，如果需要传输的数据很长，就必须分割成多个帧进行发送；尾部固定为4个字节，表示数据帧校验序列，用于确定数据包在传输过程中是否损坏。

![](https://images2015.cnblogs.com/blog/849589/201706/849589-20170627230337836-1160857612.png)

#### 网络层-IP数据包

网络层定义了IP地址，明确了主机所在的网段。网络层的主要工作是定义网络地址，区分网段，子网内MAC寻址，对于不同子网的数据包进行路由。

在网络层被包装的数据包就叫IP数据包，IP数据包由首部和数据两部分组成，首部长度为20个字节，主要包含了目标IP地址和源IP地址，目标IP地址是网关路由的线索和依据；数据部分的最大长度为65515字节，理论上一个IP数据包的总长度可以达到65535个字节，而以太网数据包的最大长度是1500个字符，如果超过这个大小，就需要对IP数据包进行分割，分成多帧发送。

![](https://images2015.cnblogs.com/blog/849589/201706/849589-20170627230819352-761232884.png)

![IP数据包](https://i.ibb.co/pWYNXzn/IP.png)

#### 传输层-UDP数据包

传输层以端口的形式定义了传输和接收包的应用程序。传输层的主要工作是定义端口，标识应用程序身份，实现端口到端口的通信，TCP协议可以保证数据传输的可靠性。

为了给每个应用程序标识身份，UDP协议定义了端口，同一个主机上的每个应用程序都需要指定唯一的端口号，并且规定网络中传输的数据包必须加上端口信息。 这样，当数据包到达主机以后，就可以根据端口号找到对应的应用程序了。UDP定义的数据包就叫做UDP数据包，结构如下所示：

![](https://images2015.cnblogs.com/blog/849589/201706/849589-20170627231338914-948536970.png)

UDP数据包由首部和数据两部分组成，首部长度为8个字节，主要包括源端口和目标端口；数据最大为65527个字节，整个数据包的长度最大可达到65535个字节。

#### 传输层-TCP数据包

TCP就是有确认机制的UDP协议，每发出一个数据包都要求确认，如果有一个数据包丢失，就收不到确认，发送方就必须重发这个数据包。

为了保证传输的可靠性，TCP 协议在 UDP 基础之上建立了三次对话的确认机制，也就是说，在正式收发数据前，必须和对方建立可靠的连接。

#### 位 字节 字的关系

位bit：0,1表示；

字节byte：最常用的字节是八位的字节，即它包含八位的二进制数。一般两个16进制数表示一个字节；

字word：一般四个字节为一个字；

