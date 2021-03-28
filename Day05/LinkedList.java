package Day05;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 02
 * Time:15:27
 */
class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}

public class LinkedList {
    public Node head;
    //创建链表连接
    public Node creatLinkedList(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = node1;
        return head;
    }
    //显示链表所有元素
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.println(cur.val + " ");
            cur = cur.next;
        }
        System.out.println("");
    }
    //获取链表长度
    public int size(){
        Node cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //找到最后一个结点
    public Node findLastNode(){
        Node cur = this.head;
        while (cur.next != null){
            cur = cur.next;
        }
        return cur;
    }
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head != null) {
            node.next = this.head;
        }
        this.head = node;
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else {
            Node last = findLastNode();
            last.next = node;
        }
    }
    //在任意位置插入，第一个数据结点为0号下标
    public void addIndex(int data,int n){
        Node node  = new Node(data);
        int size = size();
        //判断N的合法性
        if(n < 0 || n >size){
            System.out.println("插入位置不合法");
            return ;
        }
        //在第一个位置插入
        if(n == 0){
            addFirst(data);
            return ;
        }
        //在最后一个位置插入
        if(n == size){
            addLast(data);
            return ;
        }
        //找到n-1的位置
        Node cur = searchIndex(n);
        node.next = cur.next;
        cur.next = node;
    }
    //找到index-1位置
    public Node searchIndex(int index){
        Node cur = this.head;
        int count = 0;
        while (count != index-1){
            count++;
            cur =cur.next;
        }
        return cur;
    }
    //查找链表是否存在关键字Key
    public boolean contains(int key){
        Node cur = this.head;
        while (cur != null){
            if(cur.val == key)
                return true;
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现key的结点
    public void remove(int key){
        if(this.head == null){
            System.out.println("链表为空，删除失败");
        }
        //删除只有一个的,且第一个为就位key
        if(this.head.val == key){
            this.head = this.head.next;
            return ;
        }
        //找到前驱删除
        Node node = searchPre(key);
        if(node == null){
            System.out.println("找不到，删除失败");
        }else {
            node.next = node.next.next;
        }
    }
    //找到关键字key的直接前驱
    public Node searchPre(int key){
        if(this.head == null){
            return null;
        }
        Node cur = this.head;
        while (cur.next != null){
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return cur;
    }
    //删除所有key
    public void remove1(int key){
        if(this.head == null){
            return ;
        }
        Node prev = this.head;
        Node cur = this.head.next;

        while (cur != null){
            if(cur.val == key){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.val == key){
            this.head = this.head.next;
        }
    }
    public void clear(){
        this.head = null;
    }

}
