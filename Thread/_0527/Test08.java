package Thread._0527;

/**
 * Created with IntelliJ IDEA.
 * Description:可重入锁
 * User:吴博
 * Date:2021 05 27
 * Time:21:06
 */
public class Test08 {
    private static Object lock = new Object();

    public static void main(String[] args) {
        synchronized (lock){
            System.out.println("第一次进入锁");
            synchronized (lock){
                System.out.println("第二次进入锁");
            }
        }
    }
}
