package Thread._0519;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 19
 * Time:20:12
 */
public class Test04 {
    public static void main(String[] args) {
        //创建能执行定时任务的线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        System.out.println(new Date());
        //执行任务
        /*service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行时间：" + new Date());
            }
        },1,3, TimeUnit.SECONDS);*/
        //即时执行
        /*service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行时间：" + new Date());
            }
        },3, TimeUnit.SECONDS);*/
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行时间：" + new Date());
            }
        },1,3, TimeUnit.SECONDS);
    }
}
