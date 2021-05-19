package Thread._0519;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 19
 * Time:21:12
 */
public class Test07 {
    public static void main(String[] args) throws InterruptedException {
        //根据当前工作环境创建线程池
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        //判断当前线程池是否终止,等待异步线程池是否执行完成，根据终止状态判断
        while (!service.isTerminated()){
        }
    }
}
