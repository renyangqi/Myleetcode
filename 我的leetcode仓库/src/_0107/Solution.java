package _0107;

import java.util.*;

import java.util.List;


public class Solution {

    class Pair<K, V> {
        public K treeNode;
        public V level;

        public Pair(K treeNode, V level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.add(new Pair<TreeNode, Integer>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> item = queue.poll();
            TreeNode treeNode = item.treeNode;
            Integer level = item.level;
            if (level == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(new Pair<TreeNode, Integer>(treeNode.left, level + 1));
            }
            if (treeNode.right != null) {
                queue.add(new Pair<TreeNode, Integer>(treeNode.right, level + 1));
            }
        }
        res = reverse(res);
        return res;
    }

    private List<List<Integer>> reverse(List<List<Integer>> res) {
        Collections.reverse(res);
        return res;
    }
}

