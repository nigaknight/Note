package printABC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nigaknight
 * @time 2019/9/17
 **/
public class PrintABC {
    private static int count=30;
    private static final Lock lock=new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1=new Thread(new PrintA());
        Thread thread2=new Thread(new PrintB());
        Thread thread3=new Thread(new PrintC());
        thread1.start();
        thread2.start();
        thread3.start();
    }
    static class PrintA implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;){
                try {
                    lock.lock();
                    while (count%3==0){
                        System.out.println("A");
                        count++;
                        i++;
                    }
                }
                finally {
                    lock.unlock();
                }

            }
        }
    }
    static class PrintB implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;){
                try {
                    lock.lock();
                    while (count%3==1){
                        System.out.println("B");
                        count++;
                        i++;
                    }
                }
                finally {
                    lock.unlock();
                }

            }
        }
    }
    static class PrintC implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;){
                try {
                    lock.lock();
                    while (count%3==2){
                        System.out.println("C");
                        count++;
                        i++;
                    }
                }
                finally {
                    lock.unlock();
                }
            }
        }
    }
}
