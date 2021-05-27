package Thread._0527;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 27
 * Time:19:49
 */
public class Test03 {
    private static final AtomicReference<Integer> money = new AtomicReference<>(100);

    public static void main(String[] args) {
        //转账线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b =  money.compareAndSet(100,0);
                System.out.println(b + ":" + money);
            }
        });
        t1.start();
        //转账线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b =  money.compareAndSet(100,0);
                System.out.println(b + ":" + money);
            }
        });
        t2.start();
    }
}
