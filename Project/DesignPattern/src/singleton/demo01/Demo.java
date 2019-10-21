package singleton.demo01;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Demo {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.INSTANCE;
        Singleton singleton2=Singleton.INSTANCE;
        System.out.println(singleton1==singleton2);
    }
}
