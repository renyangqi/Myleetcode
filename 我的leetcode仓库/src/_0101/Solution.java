package _0101;
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //ȡ������
        TreeNode LeftNode = root.left;
        //ȡ������
        TreeNode rightNode = root.right;
        //��ת������
        LeftNode = invertTree(LeftNode);
        //�ж������ӿ����Ƿ���ͬ
        boolean res = isSameTree(LeftNode, rightNode);
        return res;
    }
    //�ж����������Ƿ���ͬ
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //���pΪnull ��鿴q,���qҲ��null ����true ���򷵻�false
        if (p == null) {
            return q == null ? true : false;
        }
        //���qΪnull ��鿴p,���pҲ��null ����true ���򷵻�false
        if (q == null) {
            return p == null ? true : false;
        }
        //���p����������p������������ͬ����false
        if (isSameTree(p.left, q.left) == false) {
            return false;
        }
        //���p����������q������������ͬ����false
        if (isSameTree(p.right, q.right) == false) {
            return false;
        }
        //���򷵻�p��q����������Ƿ����
        return p.val == q.val;
    }
    //��ת��rootΪ���Ķ����������ط�ת������ĸ�
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //��¼����������ʱ����
        TreeNode temp = root.right;
        //��ת������������������λ��
        root.right = invertTree(root.left);
        //��ת������������������λ��
        root.left = invertTree(temp);
        //���ظ��ڵ�
        return root;
    }
}

