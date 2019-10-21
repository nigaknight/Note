package singleton.demo07;

import java.util.concurrent.*;

/*
 * @author nigaknight
 * @time 2019/8/3
 * 多线程环境中懒汉式需要同步
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton> callable=new Callable<Singleton>() {
            @Override
            public Singleton call() throws Exception {
                return Singleton.getInstance();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Singleton> submit = executorService.submit(callable);
        Future<Singleton> submit1 = executorService.submit(callable);
        Singleton singleton = submit.get();
        Singleton singleton1 = submit1.get();
        System.out.println(singleton==singleton1);
        executorService.shutdown();
    }
}
