package singleton.demo02;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Demo {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getINSTANCE();
        Singleton singleton2=Singleton.getINSTANCE();
        System.out.println(singleton1==singleton2);
    }
}
