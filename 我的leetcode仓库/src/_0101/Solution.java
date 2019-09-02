package _0101;
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //取左子树
        TreeNode LeftNode = root.left;
        //取右子树
        TreeNode rightNode = root.right;
        //翻转左子树
        LeftNode = invertTree(LeftNode);
        //判断左右子棵树是否相同
        boolean res = isSameTree(LeftNode, rightNode);
        return res;
    }
    //判断左右子树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果p为null 则查看q,如果q也是null 返回true 否则返回false
        if (p == null) {
            return q == null ? true : false;
        }
        //如果q为null 则查看p,如果p也是null 返回true 否则返回false
        if (q == null) {
            return p == null ? true : false;
        }
        //如果p的左子树和p的右子树不相同返回false
        if (isSameTree(p.left, q.left) == false) {
            return false;
        }
        //如果p的右子树和q的右子树不相同返回false
        if (isSameTree(p.right, q.right) == false) {
            return false;
        }
        //否则返回p和q这两个结点是否相等
        return p.val == q.val;
    }
    //反转以root为根的二叉树，返回反转后的树的根
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //记录右子树的临时变量
        TreeNode temp = root.right;
        //反转右子树插在左子树的位置
        root.right = invertTree(root.left);
        //反转右子树插在左子树的位置
        root.left = invertTree(temp);
        //返回根节点
        return root;
    }
}

