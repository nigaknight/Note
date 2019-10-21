package threadPool.demo02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author nigaknight
 * @time 2019/9/17
 **/
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Worker());
    }
    static class Worker implements Runnable {

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
