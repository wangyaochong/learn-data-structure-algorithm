package leetcode.byNumber;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p114_FlattenBinaryTreetoLinkedList_更好 {

    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }


    @Test
    public void test() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode5;
        treeNode1.right = treeNode6;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        flatten(treeNode2);
        System.out.println(treeNode2);
    }
}
