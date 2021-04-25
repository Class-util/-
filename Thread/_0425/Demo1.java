package Thread._0425;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 25
 * Time:19:11
 */
public class Demo1 {


    public static void main(String[] args) {
        //lambda+匿名内部类的方式创建线程
        Thread thread = new Thread(()->{
            System.out.println("当前线程名为：" + Thread.currentThread().getName());
        });
        thread.start();
    }

    public static void main5(String[] args) {
        //匿名内部类的方式创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程名为：" + Thread.currentThread().getName());
            }
        });
        thread.start();
    }

    public static void main4(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    //创建方法2
    public static void main3(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("当前线程名为：" + Thread.currentThread().getName());
            }
        };
        thread.start();
    }


    //创建方法1：继承Thread类
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("当前线程名为：" + Thread.currentThread().getName());
        }
    }

    public static void main2(String[] args) throws InterruptedException {
        Thread myThread = new MyThread();
        myThread.start();
        myThread.join();
        System.out.println(myThread.getName());
    }


    public static void main1(String[] args) throws InterruptedException {
        String str = "夏天的风，我永远记得；清清楚楚的说你爱我";
        long start = System.currentTimeMillis();
        for(char ch : str.toCharArray()){
            System.out.print(ch);
            Thread.sleep(300);
        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end-start);
    }
}
