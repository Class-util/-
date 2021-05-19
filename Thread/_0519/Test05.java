package Thread._0519;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 19
 * Time:20:58
 */
public class Test05 {
    public static void main(String[] args) {
        //创建单个执行定时任务的线程池
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    }
}
