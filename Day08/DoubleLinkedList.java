package Day08;

import org.w3c.dom.Node;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 07
 * Time:19:46
 */
//class ListNode {
//    private int val;
//    private ListNode next;
//    public ListNode prev;
//
//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//
//    public ListNode getNext() {
//        return next;
//    }
//
//    public void setNext(ListNode next) {
//        this.next = next;
//    }
//
//    public ListNode getPrev() {
//        return prev;
//    }
//
//    public void setPrev(ListNode prev) {
//        this.prev = prev;
//    }
//
//    //alt+insert   ->   Constructor
//    public ListNode(int val) {
//        this.val = val;
//    }
//}
public class DoubleLinkedList {
    private ListNode head;//头
    private ListNode last;

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
            return ;
        }
        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
            return ;
        }
        this.last.setNext(node);
        node.setPrev(this.last);
        this.last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        ListNode node = new ListNode(data);
        if(index < 0 || index > size()){
            System.out.println("位置不合法，插入失败");
            return ;
        }
        if(this.head == null){
            this.head = node;
            return ;
        }
        if(index == 0){
            addFirst(data);
            return ;
        }
        if(index == size()){
            addLast(data);
            return ;
        }

        ListNode cur = this.head;
        int count = 0;
        while (count != index){
            cur = cur.getNext();
            count++;
        }
        ListNode prev = cur.getPrev();
        prev.setNext(node);
        node.setPrev(prev);
        node.setNext(cur);
        cur.setPrev(node);
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null){
            if(cur.getVal() == key)
                return true;
            cur = cur.getNext();
        }
        return false;
    }
    //找到key的前驱节点
    public ListNode findK(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.getVal() == key){
                return cur.getPrev();
            }
            cur = cur.getNext();
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(this.head == null)
            return ;
        if(this.head.getVal() == key){
            this.head = this.head.getNext();
            this.head.setPrev(null);
            return ;
        }
        ListNode cur = this.head;
        while (cur != null){
            if(cur.getVal() == key){
                if(cur == last){
                    cur.getPrev().setNext(null);
                    this.last = cur.getPrev();
                    return ;
                }
                ListNode prev = cur.getPrev();
                ListNode curNext = cur.getNext();
                curNext.setPrev(prev);
                prev.setNext(curNext);
                break;
            }
            cur = cur.getNext();
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
       ListNode cur = this.head;
       while(cur != null){
           if(cur.getVal() ==key){
               if(cur == this.head){
                   this.head = this.head.getNext();
                   this.head.setPrev(null);
               }else if(cur == this.last){
                   cur.getPrev().setNext(null);
                   this.last = this.last.getPrev();
               }else {
                   cur.getPrev().setNext(cur.getNext());
                   cur.getNext().setPrev(cur.getPrev());
               }
           }
           cur = cur.getNext();
       }
    }
    //得到单链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public void display() {
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
        System.out.println(" ");
    }
    public void clear() {
        this.head = this.last = null;
    }
}

