package _0111;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //如果左子树是空返回右子树的最小深度+1
        if (root.left == null) {
            return minDepth(root.right)+1;
        }
        //如果右子树是空返回左子树的最小深度+1
        if (root.right == null) {
            return minDepth(root.left)+1;
        }
        //否则返回左右子树中长度最小的深度+1
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
