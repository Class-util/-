package Thread._0519;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 19
 * Time:19:35
 */
public class Test01 {
    public static void main(String[] args) {
        //创建固定个数的线程池(来自juc包)
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //不用start，只需设置任务，自动执行

        for (int i = 0; i < 10; i++) {
            //设置任务
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
