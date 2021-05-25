package Thread._0525;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:自定义阻塞队列
 * User:吴博
 * Date:2021 05 25
 * Time:21:16
 */
public class Test08 {

    static class MyBlockQueue{
        //实际存储数据的数组
        private int[] values;
        //队首
        private int first;
        //队尾
        private int last;
        //队列元素长度
        private int size;
        //初始化
        public MyBlockQueue(int initial){
            values = new int[initial];
            first = last = size = 0;
        }
        //添加
        public void offer(int num){
            synchronized (this){
                //判断边界值
                if(size == values.length){
                    //队列满
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                values[last] = num;
                last++;
                size++;
                //判断是否为最后一个元素，循环队列
                if(last == values.length){
                    last = 0;
                }
                //尝试唤醒消费zhe
                this.notify();
            }
        }
        //查询方法
        public int poll(){
            int ret = -1;
            synchronized (this){
                if(size == 0){
                    //队列为空
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //取元素
                ret = values[first];
                first++;
                size--;
                //判断是否为最后一个元素
                if(first == values.length){
                    first = 0;
                }
                //尝试唤醒生产者
                this.notify();
            }
            return ret;
        }
    }

    public static void main(String[] args) {

        MyBlockQueue myBlockQueue = new MyBlockQueue(100);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int num = new Random().nextInt(10);
                    System.out.println("生产了随机数" + num);
                    myBlockQueue.offer(num);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int ret = myBlockQueue.poll();
                    System.out.println("消费了数据" + ret);
                }
            }
        });
        t2.start();
    }
}
