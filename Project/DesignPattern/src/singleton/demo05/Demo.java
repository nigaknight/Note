package singleton.demo05;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Demo {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton1==singleton2);
    }
}
