package multiThread.demo08;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo08 {
    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable,"t");
        thread.start();
        System.out.println(thread.getName());
        System.out.println(thread.getId());
        System.out.println(thread.getPriority());
        System.out.println(thread.isAlive());;
        System.out.println(thread.isDaemon());
        System.out.println(thread.getState());
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
