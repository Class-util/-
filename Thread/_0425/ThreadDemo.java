package Thread._0425;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 25
 * Time:19:55
 */
public class ThreadDemo {
    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() {
            int num = new Random().nextInt(10);
            System.out.println("子线程：" + num);
            return num;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建callable
        MyCallable callable = new MyCallable();
        //接收返回值
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //创建线程
        Thread thread = new Thread(futureTask);
        thread.start();
        int ret = futureTask.get();
        System.out.println(ret);
        //休眠1s
        TimeUnit.SECONDS.sleep(1);
        //休眠1天
        TimeUnit.DAYS.sleep(1);
        //休眠1s
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    }
}
