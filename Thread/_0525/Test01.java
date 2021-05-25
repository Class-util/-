package Thread._0525;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 25
 * Time:19:00
 */
public class Test01 {

    public static class OOMObject{
        byte[] bytes = new byte[1 *1024 *1024];
    }

    static ThreadLocal<OOMObject> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    OOMObject object = new OOMObject();
                    System.out.println(finalI);
                    local.set(object);
                    object = null;
                }
            });
            t.start();            Thread.sleep(200);
        }
    }
}
