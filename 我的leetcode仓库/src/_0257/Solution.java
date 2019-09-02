package _0257;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        List<String> leftPath = binaryTreePaths(root.left);
        for (String s : leftPath) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val + "");
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        List<String> rightPath = binaryTreePaths(root.right);
        for (String s : rightPath) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(root.val + "");
            sb2.append("->");
            sb2.append(s);
            res.add(sb2.toString());
        }
        return res;
    }
}
