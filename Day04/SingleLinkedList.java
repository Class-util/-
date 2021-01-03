package Day04;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2020 12 31
 * Time:13:16
 */
//结点
class Node{
    //值域
    public int val;
    //next域用来存放下一个结点的地址,是Node类型的
    public Node next;
    //构造方法，两种，一个是无参，一个是有参（只包含值域）
    public Node() {
    }
    public Node(int val) {
        this.val = val;
    }
}

//单链表实现
public class SingleLinkedList {
    //定义一个head结点指向单链表第一个结点
    public Node head;
    //创建单链表,并返回单链表第一个结点
    public void createLinkedList(){
        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
        //连接链表操作
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        head = node1;
    }
    //打印单链表
    public void display(){
        Node cur = head;
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
//        //如果单链表为空
//        if(head == null)
//            return 0;
//        //如果单链表只有一个结点
//        if(head.next == null)
//            return 1;
//        //定义计数器，来计数链表长度
//        int count = 1;
//        Node cur = head;
//        while (cur.next != null){
//            count++;
//            cur = cur.next;
//        }
//        return count;
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;//2
            cur = cur.next;
        }
        return count;
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
    public void addFirst(int data){
        //创造这个结点
        Node node = new Node(data);
        //如果当前链表为空，直接将head指向它
        if(head == null){
            head = node;
        }else {
            //如果不为空，直接插入
            node.next = head;
            head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        //创造这个结点
        Node node = new Node(data);
        //如果当前链表为空，直接将head指向它
        if(head == null){
            head = node;
        }else {
            //如果不为空，则找到其最后一个结点
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        //创造这个结点
        Node node = new Node(data);
        //判断插入位置是否合法
        if(index < 0 || index > size()) {
            System.out.println("index不合法");
            return;
        }
        //如果插入位置在第一个，直接进行头插法
        if (index == 0){
            addFirst(data);
            return ;
        }
        //如果在最后一个位置插入，直接进行尾插法
        if(index == size()){
            addLast(data);
            return ;
        }
        //找到index-1位置
        Node cur = moveIndex(index);
        node.next = cur.next;
        cur.next = node;
    }
    //找到index-1的位置
    public Node moveIndex(int index){
        Node cur = this.head;
        int count = 0;
        while (count != index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = head;
        while (cur != null){
            if(cur.val == key)
                return true;
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null)
            return ;
        Node cur = this.head;
        //如果第一个结点为key
        if(cur.val == key){
            head = cur.next;
        }else {
            while (cur.next != null){
                if(cur.next.val == key){
                    cur.next = cur.next.next;
                    return ;
                }
                cur = cur.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(head == null){
            return ;
        }
        Node cur = head.next;
        Node pre = head;


        while (cur != null){
            if(cur.val == key){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        if(head.val == key){
            this.head = head.next;
        }
    }
    public void clear(){
        head = null;
    }
    public Node findN(int n){
        if(this.head == null){
            System.out.println("链表为空");
            return null;
        }
        if(n <= 0){
            System.out.println("n太小了");
            return null;
        }
        if(n > size()){
            System.out.println("n太大了");
            return null;
        }
        int count = 1;
        Node cur = head;
        while (count != n){
            count++;
            cur = cur.next;
        }
        return cur;
    }
    //删除第一次出现关键字为key的节点
    public void remove1(int key){
        if(head == null){
            System.out.println("链表为空，删除失败");
            return ;
        }
        if(this.head.val == key){
            this.head = this.head.next;
            return ;
        }
        //找到要删除结点的直接前驱
        Node pre = searchKey(key);
        if(pre == null){
            System.out.println("找不到key，删除失败");
        }else {
            //key结点
            Node del = pre.next;
            pre.next = del.next;
        }
    }
    //寻找key结点的前驱
    public Node searchKey(int key){
        Node cur = head;
        while (cur.next != null){
            if(cur.next.val == key)
                return cur;
            cur = cur.next;
        }
        return null;
    }
    //删除所有值为key的节点
    public void removeAllKey1(int key){
        Node prev = this.head;
        Node cur = prev.next;

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
    //反转链表
    public Node reverseList(){
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;

        while (cur != null){
            Node curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    //反转链表 ，头插法实现
    public Node reverseList1(){
        Node cur = this.head;

        Node pre = new Node();
        Node curNext = null;

        while (cur != null){
            //记录要插入的结点
            curNext = cur.next;
            cur.next = pre.next;

            pre.next = cur;
            cur = curNext;
        }
        return pre.next;
    }
    //找到中间结点的两种方法
    //1.用长度来计算
    public Node middleNode1() {
        int len = size()/2;
        Node cur = this.head;
        int count = 0;
        while (count != len){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //定义快慢指针
    public Node middleNode(){
        Node low = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }
}
