package Day09;

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 26
 * Time:11:13
 */
public class TestDemo {

    public static void main(String[] args) {
        HeapDemo heapDemo = new HeapDemo();
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        System.out.println(Arrays.toString(arr));
        heapDemo.creatBigHeap(arr);
        heapDemo.show();
        heapDemo.push(100);
        System.out.println("");
        heapDemo.show();
        System.out.println("");
        System.out.println(heapDemo.poll());
        heapDemo.show();
    }

    public static void main1(String[] args) {
        BinaryTree tree = new BinaryTree();
        BTNode tree1 = tree.createTree();
//        tree.getSize1(tree1);
//        System.out.println(BinaryTree.size);
//        System.out.println(tree.getSize2(tree1));
//        tree.getLeafSize1(tree1);
//        System.out.println(BinaryTree.leafSize);
//        System.out.println(tree.getLeafSize2(tree1));
//        System.out.println(tree.getKLevelSize(tree1, 4));
//        System.out.println(tree.getHeight(tree1));
//        tree.levelOrderTraversal(tree1);
//        int i = tree.widthOfBinaryTree(tree1);
//        System.out.println(i);
        tree.preOrderTraversal1(tree1);
        System.out.println("");
        tree.inOrderTraversal1(tree1);
        System.out.println("");
        tree.inOrderTraversal(tree1);
        System.out.println("");
        tree.postOrderTraversal1(tree1);
        System.out.println("");
        tree.postOrderTraversal(tree1);
    }

    public boolean isSubtree(BTNode s, BTNode t) {
        if(s == null || t == null){
            return false;
        }
        if(isSameTree(s,t))
            return true;
        if(isSubtree(s.left,t))
            return true;
        if(isSubtree(s.right,t))
            return true;
        return false;
    }


    public static boolean isSameTree(BTNode p, BTNode q) {
        //两个有一个为空，返回false
        if(p != null && q == null || p== null && q != null){
            return false;
        }
        //两个都为空
        if(p == null && q == null){
            return true;
        }
        //两个都不为空l
        if(p.val != q.val){
            return false;
        }
        //返回值要判断，左子树和右子树是否都相同
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
