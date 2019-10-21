import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author nigaknight
 * @time 2019/9/25
 **/
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
