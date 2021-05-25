package Thread._0525;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 25
 * Time:19:00
 */
public class Test02 {

    static class OOMObject{
        byte[] bytes = new byte[1 * 1024 * 1024];
    }

    static ThreadLocal<OOMObject> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //try {
                        OOMObject object = new OOMObject();
                        System.out.println(finalI);
                        local.set(object);
                        object = null;
                    //}finally {
                        local.remove();
                    //}
                }
            });
            //Thread.sleep(200);
        }
    }
}
