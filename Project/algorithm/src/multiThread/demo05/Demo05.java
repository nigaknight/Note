package multiThread.demo05;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo05 {
    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread thread=new Thread(myRunnable);
        thread.start();
        for (int i=0;i<10;i++){
            if (i==2){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
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