package Thread._0425;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 25
 * Time:19:45
 */

//创建方法：实现Runnable接口
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("当前线程名为：" + Thread.currentThread().getName());
    }
}
