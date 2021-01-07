package Day08;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 07
 * Time:20:08
 */
public class Test01 {
    public static void main(String[] args) {
        Test02 l = new Test02();
        l.addFirst(1);
        l.addFirst(1);
        l.addFirst(1);
        l.addFirst(1);
        l.addFirst(1);
        l.removeAllKey(1);
        l.display();
    }
}
