package Thread._0525;

/**
 * Created with IntelliJ IDEA.
 * Description:懒汉方式V4版本
 * User:吴博
 * Date:2021 05 25
 * Time:20:28
 */
public class Test07 {
    static class Singleton{
        // //1.创建一个私有构造函数:防止其他类直接创建
        private Singleton(){
        }
        //2.定义私有变量
        private static volatile Singleton singleton = null;
        //3.提供公共的获取实例的方法
        public static Singleton getInstance(){
            //判断是否第一次访问
            if(singleton == null){
                synchronized (Singleton.class){
                    if(singleton == null){
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }

    static Singleton s1 = null;
    static Singleton s2 = null;

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
