package singleton.singleton02;

/**
 * @author nigaknight
 * @time 2019/9/17
 **/
public class Singleton {
    static Singleton  INSTANCE;
    private Singleton(){

    }
    public Singleton getINSTANCE(){
        return INSTANCE;
    }
}
