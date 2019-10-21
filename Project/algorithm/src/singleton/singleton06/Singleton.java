package singleton.singleton06;

/**
 * @author nigaknight
 * @time 2019/9/24
 **/
public class Singleton {
    private static final Singleton INSTANCE=new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return INSTANCE;
    }
}
