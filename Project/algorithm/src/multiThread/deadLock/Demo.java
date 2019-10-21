package multiThread.deadLock;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Demo {
    public static void main(String[] args) {
        DeadLock deadLock=new DeadLock();
        Thread t1=new Thread(deadLock,"t1");
        Thread t2=new Thread(deadLock,"t2");
        t1.start();
        t2.start();
        while (true){
            System.out.println(t1.getState());
            System.out.println(t2.getState());
        }
    }
}

class DeadLock implements Runnable{
    private final Object lock1=new Object();
    private final Object lock2=new Object();
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                setA();
            } else {
                setB();
            }
        }
    }

    private void setA(){
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+" 获得锁1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+" 获得锁2");
            }
        }
    }

    private void setB(){
        synchronized (lock2){
            System.out.println(Thread.currentThread().getName()+" 获取锁2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+" 获取锁1");
            }
        }
    }
}
