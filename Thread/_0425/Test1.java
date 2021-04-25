package Thread._0425;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 25
 * Time:20:33
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        String str = "ABCD";
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(char ch : str.toCharArray()){
                    System.out.print(ch);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(char ch : str.toCharArray()){
                    System.out.print(ch);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"第二个");
        t1.start();
        System.out.println(t2.getName());
        t2.start();
    }
}
