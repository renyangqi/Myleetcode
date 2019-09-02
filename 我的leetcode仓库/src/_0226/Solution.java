package _0226;
//错误的代码
/*class Solution {
    //反转以root为根的二叉树，返回反转后的树的根
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.right = invertTree(root.left);
        root.left = invertTree(root.right);
        return root;
    }
}*/

class Solution {
    //反转以root为根的二叉树，返回反转后的树的根
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //注意temp如果没有就无法交换
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}