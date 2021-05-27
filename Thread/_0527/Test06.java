package Thread._0527;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA.
 * Description:ABA问题的解决
 * User:吴博
 * Date:2021 05 27
 * Time:19:49
 */
public class Test06 {
    private static final AtomicStampedReference<Integer> money = new AtomicStampedReference<>(1000,1);

    public static void main(String[] args) throws InterruptedException {
        //转账线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b =  money.compareAndSet(1000,0,1,2);
                System.out.println(b + "转出1000元：" + money);
            }
        });
        t1.start();
        t1.join();
        //转入100元
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b =  money.compareAndSet(0,1000,2,3);
                System.out.println(b + "转入1000元：" + money);
            }
        });
        t3.start();
        t3.join();
        //转账线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b =  money.compareAndSet(1000,0,1,2);
                System.out.println(b + "转出1000元：" + money);
            }
        });
        t2.start();
    }
}
