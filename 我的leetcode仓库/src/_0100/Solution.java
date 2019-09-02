package _0100;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //���pΪnull ��鿴q���qҲ��null ����true ���򷵻�false
        if (p == null) {
            return q == null ? true : false;
        }
        //���qΪnull ��鿴p���pҲ��null ����true ���򷵻�false
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
