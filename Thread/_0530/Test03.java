package Thread._0530;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * Description:循环屏障
 * User:吴博
 * Date:2021 05 30
 * Time:10:02
 */
public class Test03 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行了CyclicBarrier的任务");
            }
        });
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "：开始起跑");
                    try {
                        Thread.sleep(200 * finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(Thread.currentThread().getName() + "：到达终点");
                        //计数器减一，并判断是否为0，不为0就阻塞等待
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
