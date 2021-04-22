package Thread._0422;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 22
 * Time:21:22
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        //创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(60*60*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        thread.start();
    }
}
