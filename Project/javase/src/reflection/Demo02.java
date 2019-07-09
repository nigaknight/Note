package reflection;

import java.lang.reflect.Constructor;

/*
    @author nigaknight
    @since 2019/7/8 22:06
    通过反射获取构造方法并使用
*/
public class Demo02 {
    public static void main(String[] args) throws Exception {
        Class c=Class.forName("reflection.Person");

        System.out.println("通过getConstructors方法获取公共的构造函数");
        Constructor[] constructors = c.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor);
        }

        System.out.println("通过getDeclaredConstructors方法获取所有的构造函数");
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        for(Constructor constructor:declaredConstructors){
            System.out.println(constructor);
        }

        // 按参数个数和类型获取构造方法
        System.out.println("获取单个无参构造方法");
        Constructor constructor = c.getConstructor();
        System.out.println(constructor);

        System.out.println("获取三个参数的构造方法");
        Class c2=Class.forName("reflection.Person");
        Constructor constructor1 = c.getConstructor(String.class, int.class, String.class);
        System.out.println(constructor1);
        System.out.println("通过带参构造方法创建对象");
        Object obj=constructor1.newInstance("邓紫棋",27,"香港");
        System.out.println(obj);
    }
}
