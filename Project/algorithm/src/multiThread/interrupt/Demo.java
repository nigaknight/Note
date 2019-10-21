package multiThread.interrupt;

/**
 * @author nigaknight
 * @time 2019/10/4
 **/
public class Demo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        try {
            System.out.println("thread sleep start");
            Thread.sleep(1000);
            System.out.println("thread sleep completed");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }
}
