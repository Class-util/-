package Thread._0509;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 09
 * Time:11:10
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("A");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B");
                }
            }
        },"t1");
        t1.start();
        Thread.sleep(1000);
        System.out.println("唤醒");
        synchronized (lock){
            lock.notify();
        }
    }
}
