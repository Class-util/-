package Thread._0523;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 05 23
 * Time:12:08
 */
public class Test01 {
    static  ThreadLocal<String> local = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                local.set(name);
                System.out.println(String.format("线程%s，设置了：%s",name,name));
                printTname();
            }
        });
        t.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                local.set(name);
                System.out.println(String.format("线程%s，设置了：%s",name,name));
                printTname();
            }
        });
        t2.start();
    }

    private static void printTname() {
        String tname = Thread.currentThread().getName();
        String name = local.get();
        System.out.println(String.format("线程%s,名字为：%S",tname,name));
    }
}
