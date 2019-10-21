package multiThread.synchronizedDemo;

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
    private final Object lock=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if (tickets>0){
                    System.out.println(Thread.currentThread().getName()+" 卖了第"+tickets--+"张票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
