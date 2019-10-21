package multiThread.demo10;

import java.util.concurrent.*;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Demo10 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> submit = executorService.submit(new MyRunnable());
        Object o = submit.get();
        System.out.println(o);
        Future submit1 = executorService.submit(new MyCallable());
        System.out.println(submit1.get());
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" myRunnable is running...");
    }
}

class MyCallable implements Callable{

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" myCallable is running...");
        return "return val";
    }
}


