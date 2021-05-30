package Thread._0530;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:计数器
 * User:吴博
 * Date:2021 05 30
 * Time:9:44
 */
public class Test02 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "：开始起跑");
                    try {
                        Thread.sleep(1000 * finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：到达终点");
                    latch.countDown();
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有人都到达终点，公布排名");
    }
}
