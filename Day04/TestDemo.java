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
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
//        singleLinkedList.remove1(1);
//        singleLinkedList.display();
//        Node node = singleLinkedList.middleNode();
//        System.out.println(node.val);
        Node node = singleLinkedList.reverseList1();
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
