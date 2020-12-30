package Day03;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2020 12 30
 * Time:20:14
 */
public class Test01 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(19);
        myLinkedList.addFirst(29);
        myLinkedList.addFirst(39);
        myLinkedList.addFirst(49);
        myLinkedList.display();
        myLinkedList.addLast(32);
        myLinkedList.addLast(31);
        myLinkedList.addLast(30);
        myLinkedList.addLast(329);
        myLinkedList.display();
    }
}
