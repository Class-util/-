package Day06;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 04
 * Time:19:18
 */
class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}

public class Test01 {
    public static void main(String[] args) {

    }
    public ListNode findK(ListNode head,int k){
        if(head == null || k <= 0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (fast != null){
            if(count != k-1){
                fast = fast.next;
                count++;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
