package Day03;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2020 12 30
 * Time:20:02
 */
class Node{
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    Node head;
    public void creatLinkedList(){

    }
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print (cur.val +" ");
            //
            cur = cur.next;
        }
        System.out.println();
    }

    //找到最后一个结点
    public Node findLastNode() {
        if(this.head == null) {
            System.out.println("head == null");
            return null;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
    //头插法
    public void addFirst(int data) {
        //0、首先你得有个节点
        Node node = new Node(data);
        //1、判断链表是不是空的
        if(this.head == null) {
            this.head = node;
        }else {
            //2、插入
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head ==null){
            this.head = node;
        }else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
}
