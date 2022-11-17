package leetcode.byNumber.p200;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

public class p105_ConstructBinaryTreeFromPreorderAndInorderTraversal_这个算法很好 {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return buildNode(preOrder, inOrder, 0, 0, preOrder.length - 1);
    }

    public TreeNode buildNode(int[] preOrder, int[] inOrder, int preIndex, int inStart, int inEnd) {
        if (inStart > inEnd || preIndex >= preOrder.length) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preOrder[preIndex]);
        int inIndex = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[preIndex]) {
                inIndex = i;
            }
        }
        //对于左边的，就直接使用下一个根节点即可
        treeNode.left = buildNode(preOrder, inOrder, preIndex + 1, inStart, inIndex - 1);
        //对于右边子树，则从要从根节点跳过左子树长度，选择右子树的根节点
        treeNode.right = buildNode(preOrder, inOrder, preIndex + 1 + inIndex - inStart, inIndex + 1, inEnd);
        return treeNode;
    }

    @Test
    public void test() {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
