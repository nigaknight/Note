package multiThread.demo07;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author nigaknight
 * @time 2019/9/30
 **/
public class Demo07 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable=new MyCallable();
        FutureTask<Integer> futureTask=new FutureTask<>(callable);
        Thread thread=new Thread(futureTask);
        thread.start();
        Integer sum = futureTask.get();
        System.out.println(sum);
    }

}
class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.currentThread().getId()+"\t"+new Date());
        int sum=0;
        for (int i=0;i<10000;i++){
            sum+=i;
        }
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.currentThread().getId()+"\t"+new Date());
        return sum;
    }
}
