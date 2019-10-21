package singleton.demo06;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){

    }
    public static Singleton getInstance() throws InterruptedException {
        if(instance==null){
            Thread.sleep(100);
            instance=new Singleton();
        }
        return instance;
    }
}
