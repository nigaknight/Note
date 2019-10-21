package singleton.demo09;

/*
 * @author nigaknight
 * @time 2019/8/3
 * idea自动生成的单例是最简单的饿汉式的
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
