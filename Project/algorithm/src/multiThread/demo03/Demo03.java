package multiThread.demo03;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo03 {
    public static void main(String[] args) {
        MyThread runnable=new MyThread();
        Thread thread=new Thread(runnable);
        thread.setName("t1");
        System.out.println(thread.getName());
        thread.start();

    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running...");
    }
}
