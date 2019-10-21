package multiThread.demo06;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo06 {
    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread thread1=new Thread(runnable);
        thread1.setName("T1");
        Thread thread2=new Thread(runnable);
        thread2.setName("T2");
        Thread thread3=new Thread(runnable);
        thread3.setName("T3");
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();
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
