package singleton.demo02;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Singleton {
    private static final Singleton INSTANCE=new Singleton();
    private Singleton(){

    }
    public static Singleton getINSTANCE(){
        return INSTANCE;
    }
}
