package Day08;/**
 *Created with IntelliJ IDEA.
 *Description:
 *User:吴博
 *Date:2021 01 07
 *Time:22:01
 *
 */
class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;
    //alt+insert   ->   Constructor
    public ListNode(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }
}
public class Test02 {
    private ListNode head;//头
    private ListNode last;

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            //node.next = this.head;
            node.setNext(this.head);
            //head.prev = node;
            this.head.setPrev(node);
            this.head = node;
        }
    }
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            // = cur.next;
            System.out.print(cur.getVal()+ " ");
            cur = cur.getNext();
        }
        System.out.println();
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            //last.next = node;
            this.last.setNext(node);
            //node.prev = last;
            node.setPrev(this.last);
            this.last = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if(index < 0 || index > size()) {
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = this.head;
        while (index != 0) {
            //cur = cur.next;
            cur = cur.getNext();
            index--;
        }
        ListNode node = new ListNode(data);
        //node.next = cur;
        node.setNext(cur);
        //node.prev = cur.prev;
        node.setPrev(cur.getPrev());
        //node.prev.next = node;
        node.getPrev().setNext(node);
        //cur.prev = node;
        cur.setPrev(node);
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.getVal() == key) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    //得到单链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public ListNode findNode(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.getVal() == key) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.findNode(key);
        if(cur == null) {
            return;
        }
        //
        if(cur == this.head) {
            this.head = this.head.getNext();
            //this.head.prev = null;
            this.head.setPrev(null);
            return;
        }
        if(cur == this.last) {
            cur.getPrev().setNext(null);
            this.last = this.last.getPrev();
            return;
        }
        cur.getPrev().setNext(cur.getNext());
        cur.getNext().setPrev(cur.getPrev());
    }

    public void remove2(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    //头结点
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        //cur.next == null
                        this.last = this.last.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    public void remove3(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else if(cur == this.last) {
                    cur.prev.next = null;
                    this.last = this.last.prev;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    //头结点
                    if(head.getNext() != null){
                        this.head.prev = null;
                    }
                    this.head = this.head.next;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        //cur.next == null
                        this.last = this.last.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    public void removeAllKey2(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else if(cur == this.last) {
                    cur.prev.next = null;
                    this.last = this.last.prev;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                //return;
            }
            cur = cur.next;
        }
    }

    public void clear() {
        this.head = null;
        this.last = null;
    }

    public void clear2() {
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = null;
            cur.prev = null;
            cur = curNext;
        }
        this.last = null;
        this.head = null;
    }
}
