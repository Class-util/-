package Day04;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2020 12 31
 * Time:13:26
 */
public class TestDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createLinkedList();
        singleLinkedList.display();
        int size = singleLinkedList.size();
        System.out.println("单链表长度为：" + size);
        singleLinkedList.addFirst(56);
        singleLinkedList.display();
        singleLinkedList.addLast(77);
        singleLinkedList.display();
        singleLinkedList.remove(56);
        singleLinkedList.display();
        System.out.println(singleLinkedList.findN(5).val);
        System.out.println(size = singleLinkedList.size());
    }
}
