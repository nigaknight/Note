/**
 * @author nigaknight
 * @time 2019/10/1
 **/
public class Demo1001 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable=new MyRunnable();
        Thread t1=new Thread(runnable,"t1");
        Thread t2=new Thread(runnable,"t2");
        Thread t3=new Thread(runnable,"t3");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running... ");
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
