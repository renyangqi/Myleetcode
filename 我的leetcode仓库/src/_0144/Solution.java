package _0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private class Command {
        String s = "";
        TreeNode treeNode;

        public Command(String s, TreeNode treeNode) {
            this.s = s;// go ���� print
            this.treeNode = treeNode;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<Integer>();
        Stack<Command> stack = new Stack<Command>();
        Command firstNode = new Command("go", root);
        stack.push(firstNode);
        while (!stack.isEmpty()) {
            Command Node = stack.pop();
            if (Node.s.equals("print")) {
                list.add(Node.treeNode.val);
            } else {

                if (Node.treeNode.right != null) {
                    stack.push(new Command("go", Node.treeNode.right));
                }
                if (Node.treeNode.left != null) {
                    stack.push(new Command("go", Node.treeNode.left));
                }
                stack.push(new Command("print", Node.treeNode));
            }
        }
        return list;
    }
}
