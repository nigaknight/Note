package singleton.demo08;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Singleton {
    private Singleton(){

    }
    private static class Inner{
        private static final Singleton INSTANCE=new Singleton();
    }
    public static Singleton getInstance(){
        return Inner.INSTANCE;
    }
}
