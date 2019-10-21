package singleton.demo05;

/*
 * @author nigaknight
 * @time 2019/8/3
 * 懒汉式单例
 */
public class Singleton {
    private static Singleton Instance;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(Instance==null){
            Instance=new Singleton();
        }
        return Instance;
    }
}
