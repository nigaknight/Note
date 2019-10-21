package singleton.demo08;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Demo {
    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        System.out.println(singleton==singleton1);
    }
}
