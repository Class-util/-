package Thread._0527;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * Description:读写锁
 * User:吴博
 * Date:2021 05 27
 * Time:20:45
 */
public class Test07 {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        //读锁
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        //写锁
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,4,0,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(1000));
        executor.execute(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ":进行了读锁操作," + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ":进行了读锁操作," + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ":进行了写锁操作," + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ":进行了写锁操作," + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        });
    }
}
