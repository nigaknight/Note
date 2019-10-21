package singleton.demo04;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Singleton {
    public static Singleton INSTANCE;
    static {
        INSTANCE=new Singleton();
    }
    private Singleton(){

    }
}
