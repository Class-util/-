package Thread._0525;

/**
 * Created with IntelliJ IDEA.
 * Description:饿汉方式
 * User:吴博
 * Date:2021 05 25
 * Time:20:18
 */

public class Test03 {

    static class Singleton{
        //1.创建一个私有构造函数:防止其他类直接创建
        private Singleton(){
        }
        //2.定义私有变量
        private static Singleton singleton = new Singleton();
        //3.提供公共的获取实例的方法
        public static Singleton getInstance(){
            return singleton;
        }
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
