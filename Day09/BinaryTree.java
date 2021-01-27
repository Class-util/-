package Day09;


import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 26
 * Time:10:35
 */
class BTNode {
    public char val;
    public BTNode left;//左子树的引用
    public BTNode right;//右子树的引用

    public BTNode(char val) {
        this.val = val;
    }
}
public class BinaryTree {
    /**
     * 我们要首先创建二叉树，但是为了好理解，我们先以穷举的方式
     * 创建二叉树
     * 后期我们会以遍历的方式 创建二叉树
     * 当前只是权宜之计
     * @return
     */
    public BTNode createTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }


    // 前序遍历
    void preOrderTraversal(BTNode root) {
        if(root == null) return;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }



    // 中序遍历
    void inOrderTraversal(BTNode root) {
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    // 后序遍历
    void postOrderTraversal(BTNode root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }

    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(BTNode root){
        if(root == null) return;
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    // 子问题思路-求结点个数
    int getSize2(BTNode root){
        if(root == null)
            return 0;
        return getSize2(root.left) + getSize2(root.right) +1;
    }
    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(BTNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(BTNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(BTNode root, int k){
        if(root == null){
            return  0;
        }
        if(k == 1)
            return 1;
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }

    // 获取二叉树的高度
    int getHeight(BTNode root){
        if(root == null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right)) +1;
    }
    // 查找 val 所在结点，没有找到返回 null
// 按照 根 -> 左子树 -> 右子树的顺序进行查找
// 一旦找到，立即返回，不需要继续在其他位置查找
    BTNode find(BTNode root, char val){
        if(root == null){
            return null;
        }
        //判断根节点
        if(root.val == val){
            return root;
        }
        //判断左节点
        BTNode ret = find(root.left, val);
        if(ret != null){
            return ret;
        }
        //判断右节点
        ret = find(root.right, val);
        if(ret != null){
            return ret;
        }
        //都判断完了，没有返回null
        return null;
    }
    //层序遍历
    void levelOrderTraversal(BTNode root){
        Queue<BTNode> queue = new LinkedList<>();
        if(root == null){
            return ;
        }
        BTNode cur = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.print(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
    public int widthOfBinaryTree(BTNode root) {
        Queue<BTNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.offer(root);
        BTNode cur = null;
        int max = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            max = Math.max(max,size);
            while(size > 0){
                cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                size--;
            }
        }
        return max ;
    }
}
