package multiThread.lockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Demo {
    public static void main(String[] args) {
        SaleTickets saleTickets=new SaleTickets();
        Thread t1=new Thread(saleTickets,"窗口1");
        Thread t2=new Thread(saleTickets,"窗口2");
        Thread t3=new Thread(saleTickets,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class SaleTickets implements Runnable{
    private int tickets=100;
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (tickets>0) {
            try {
                lock.lock();
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " 正在售卖第" + tickets-- + "张票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
