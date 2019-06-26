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