package Thread._0527;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 27
 * Time:18:54
 */
public class Test02 {
    private static AtomicInteger count = new AtomicInteger(0);
    private static final int MAXSIZE = 100000;

    public static void main(String[] args) throws InterruptedException {
        /*AtomicInteger count = new AtomicInteger(0);
        count.getAndIncrement();//i++操作，得到并且++
        count.incrementAndGet();//++i*/
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE; i++) {
                    count.getAndIncrement();//i++
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE; i++) {
                    count.getAndDecrement();//i--
                }
            }
        });
        t2.start();
        
        t1.join();
        t2.join();

        System.out.println(count);
    }
}
