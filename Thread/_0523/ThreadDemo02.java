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
 * Time:9:48
 */
public class ThreadDemo02 {

    public static int count = 1;

    public static void main(String[] args) {

        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("myThread-" + count++);
                return t;
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                factory
                );
        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
