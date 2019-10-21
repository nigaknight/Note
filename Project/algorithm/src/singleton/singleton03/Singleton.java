package singleton.singleton03;

/**
 * @author nigaknight
 * @time 2019/9/17
 **/
public class Singleton {
    private volatile Singleton INSTANCE;
    private Singleton(){

    }
    public Singleton getINSTANCE(){
        if (INSTANCE==null){
            synchronized (this){
                if (INSTANCE==null){
                    INSTANCE=new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
