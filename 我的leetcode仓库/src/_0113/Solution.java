package _0113;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer>());
            res.get(0).add(root.val);
            return res;
        }

        List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
        for (List<Integer> list : leftList) {
            list.add(0, root.val);
            res.add(list);
        }
        List<List<Integer>> rightList = pathSum(root.right, sum - root.val);
        for (List<Integer> list : rightList) {
            list.add(0, root.val);
            res.add(list);
        }
        return res;
    }

}