package Day09;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 26
 * Time:11:13
 */
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BTNode tree1 = tree.createTree();
        tree.getSize1(tree1);
        System.out.println(BinaryTree.size);
        System.out.println(tree.getSize2(tree1));
        tree.getLeafSize1(tree1);
        System.out.println(BinaryTree.leafSize);
        System.out.println(tree.getLeafSize2(tree1));
        System.out.println(tree.getKLevelSize(tree1, 4));
        System.out.println(tree.getHeight(tree1));
    }
}
