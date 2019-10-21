package multiThread.demo09;

import java.util.Date;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo09 {
    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread thread=new Thread(myRunnable);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running... "+new Date());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" is interrupted "+new Date());
        }
        System.out.println(Thread.currentThread().getName()+" is awake... "+new Date());
    }
}
