package Thread._0523;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 23
 * Time:15:37
 */
public class Test {

    static ThreadLocal<SimpleDateFormat> local = ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("mm:ss");
        }
    });
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        for (int i = 0; i < 1001; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finalI * 1000);
                    myFormat(date);
                }
            });
        }
    }

    private static void myFormat(Date date) {
        String ret = local.get().format(date);
        System.out.println(ret);
    }
}
