package multiThread.demo01;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo01 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
        myThread.run();
    }
}

class MyThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running...");
    }
}
