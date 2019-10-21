package multiThread.demo04;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo04 {
    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
class MyRunnable implements Runnable{
    private static final Object obj=new Object();
    @Override
    public void run() {
        synchronized (obj){
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+" "+i);
                if (i==4){
                    Thread.yield();
                }
            }
        }
    }
}
