package Thread._0519;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 19
 * Time:19:53
 */
public class Test02 {

    static int count = 1;

    static class MyThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("myThread-" + count++);
            return thread;
        }
    }

    public static void main(String[] args) {
        //创建线程工厂实现类
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        //使用线程工厂传参
        ExecutorService service = Executors.newFixedThreadPool(10,myThreadFactory);
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName() + " -> "
                            + "优先级：" + Thread.currentThread().getPriority());
                }
            });
        }
    }
}
