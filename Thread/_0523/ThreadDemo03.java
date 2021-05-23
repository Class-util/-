package Thread._0523;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 23
 * Time:9:59,
 */
public class ThreadDemo03 {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("Thread-" + count++);
                return t;
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                factory,
                //new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
                //new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        for (int i = 0; i < 11; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "任务" + finalI);
                }
            });
            //Thread.sleep(100);
        }
    }
}
