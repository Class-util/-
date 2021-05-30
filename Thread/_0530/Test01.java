package Thread._0530;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:信号量演示程序
 * User:吴博
 * Date:2021 05 30
 * Time:9:22
 */
public class Test01 {
    public static void main(String[] args) {
        //创建信号量
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));
        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":到达停车场");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //试图停车
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":进入停车场");
                    //停留时间
                    int num = 1 + new Random().nextInt(5);
                    try {
                        Thread.sleep(num * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":离开停车场");
                    //释放锁
                    semaphore.release();
                }
            });
        }
    }
}
