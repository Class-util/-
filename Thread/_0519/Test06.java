package Thread._0519;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 19
 * Time:21:05
 */
public class Test06 {
    public static void main(String[] args) {
        //创建单个线程的线程池
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
