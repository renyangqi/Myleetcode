package _0100;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果p为null 则查看q如果q也是null 返回true 否则返回false
        if (p == null) {
            return q == null ? true : false;
        }
        //如果q为null 则查看p如果p也是null 返回true 否则返回false
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode111 = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode222 = new TreeNode(3);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode111;

        treeNode2.left = treeNode22;
        treeNode2.right = treeNode222;
        boolean sameTree = solution.isSameTree(treeNode1, treeNode2);
        System.out.println(sameTree);
    }
}
