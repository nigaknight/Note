package multiThread.readwriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Demo {
    private Map<String,Integer> map=new HashMap<>();
    private ReadWriteLock lock=new ReentrantReadWriteLock();
    private Lock readLock=lock.readLock();
    private Lock writeLock=lock.writeLock();
    private Demo(Map<String, Integer> map){
        this.map=map;
    }
    private void put(String key, int val){
        try {
            writeLock.lock();
            map.put(key,val);
        }finally {
            writeLock.unlock();
        }
    }
    public Integer get(String key){
        try {
            readLock.lock();
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo demo=new Demo(new HashMap<>());
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<100;i++){
            executorService.execute(new MyRunnable(demo));
        }
    }

    public static class MyRunnable implements Runnable{
        Demo demo;
        String key="x";
        MyRunnable(Demo demo){
            this.demo=demo;
        }
        @Override
        public void run() {
            Random random=new Random();
            int r=random.nextInt(100);
            if (r>30){
                demo.put(key,r);
            } else {
                System.out.println(demo.get(key));
            }
        }
    }
}
