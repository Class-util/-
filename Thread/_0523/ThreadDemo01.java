package Thread._0523;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 23
 * Time:9:23
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        //原始创建线程池的方式
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                //核心线程数，正常情况下保持的线程数
                5,
                //最大线程数(非正常情况下能创建多少线程,线程+任务队列)，要大于等于核心线程数
                10,
                //最大生命周期（临时工）,临时线程的最大存活时间
                60,
                //第三个参数的单位
                TimeUnit.SECONDS,
                //任务队列(必须要设置容量，不然就和第一种创建方式无区别)
                new LinkedBlockingQueue<>(1000)
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
