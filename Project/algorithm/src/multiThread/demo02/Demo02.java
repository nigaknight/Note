package multiThread.demo02;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo02 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread,"t1");
        thread.start();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running...\n"+Thread.currentThread().getId());
    }
}
