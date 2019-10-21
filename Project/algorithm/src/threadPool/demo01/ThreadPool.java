package threadPool.demo01;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author nigaknight
 * @time 2019/9/17
 **/
public class ThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(new Worker(),0, TimeUnit.DAYS);
    }
    static class Worker implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<100;i++){
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
