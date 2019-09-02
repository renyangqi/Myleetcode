package _0101;

public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        return ismirror(root, root);
    }

    private boolean ismirror(TreeNode p, TreeNode q) {
        if (p == null && q == null)//都为NULL
            return true;
        if (p == null || q == null)//有一个为NULL
            return false;
        if (p.val == q.val)
            return ismirror(p.left, q.right) && ismirror(p.right, q.left);
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode111 = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(4);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode111;

        treeNode11.left = treeNode2;
        treeNode11.right = treeNode22;

        treeNode111.right = treeNode3;
        boolean symmetric = solution2.isSymmetric(treeNode1);
        System.out.println(symmetric);
    }
}
