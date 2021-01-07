package Day07;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 07
 * Time:16:36
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
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;

        ListNode cur = pHead;
        while(cur != null){
            if(cur.val < x){
                if(bs == null){
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null){
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null){
            return as;
        }
            be.next = as;
        if(as != null){
            as.next = null;
        }
            return be;
    }
    public boolean chkPalindrome(ListNode A) {
        if(A == null)
            return false;
        //找到中间结点
        ListNode fast = A;
        ListNode slow = A;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转后面的结点
        ListNode cur = slow.next;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        while (A != slow){
            if(A.val != slow.val)
                return false;
            if(A.next == slow){
                return true;
            }
            A = A.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        //使pl结点永远指向长的，ps结点永远指向短的
        ListNode pl = headA;
        ListNode ps = headB;
        //通过长度来分配
        int len1 = size(headA);
        int len2 = size(headB);
        int len = len1 - len2;
        if(len < 0){
            pl = headB;
            ps = headA;
            len = len2 - len1;
        }
        while (len != 0){
            pl = pl.next;
            len--;
        }
        while(pl != ps){
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }
    public static int size(ListNode head){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}
