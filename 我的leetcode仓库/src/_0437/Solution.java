package _0437;

import java.util.TreeSet;

class Solution {
    //寻找以root为根节点的二叉树中寻找和为sum的路径
    //返回该路径的数量
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    //在以root为根节点的二叉树中寻找包含root结点的和为sum的路径
    //返回路径的个数
    private int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);

        return res;
    }
}
