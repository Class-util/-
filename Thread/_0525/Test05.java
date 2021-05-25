package Thread._0525;

/**
 * Created with IntelliJ IDEA.
 * Description:懒汉方式V2版本性能不佳
 * User:吴博
 * Date:2021 05 25
 * Time:20:28
 */
public class Test05 {
    static class Singleton{
        // //1.创建一个私有构造函数:防止其他类直接创建
        private Singleton(){
        }
        //2.定义私有变量
        private static Singleton singleton = null;
        //3.提供公共的获取实例的方法
        public static synchronized Singleton getInstance(){
            //判断是否第一次访问
            if(singleton == null){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singleton = new Singleton();
            }
            return singleton;
        }
    }

    public static Singleton s1 = null;
    public static Singleton s2 = null;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s1 = Singleton.getInstance();
            }
        });
        t1.start();
        s2 = Singleton.getInstance();
        t1.join();
        System.out.println(s1 == s2);
    }
}
