package _0226;
//����Ĵ���
/*class Solution {
    //��ת��rootΪ���Ķ����������ط�ת������ĸ�
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
    //��ת��rootΪ���Ķ����������ط�ת������ĸ�
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //ע��temp���û�о��޷�����
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}