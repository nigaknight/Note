package singleton.demo07;

/*
 * @author nigaknight
 * @time 2019/8/3
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){

    }
    public static Singleton getInstance() throws InterruptedException {
        //添加这个判断更简化
 //       if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    Thread.sleep(1000);
                    instance=new Singleton();
                }
                return instance;
            }
        }
 //       return instance;
//    }
}
