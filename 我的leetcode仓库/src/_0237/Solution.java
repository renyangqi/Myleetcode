package _0237;

class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("不能是最后一个结点");
        }
        node.val = node.next.val;
        node.next = node.next.next;
        return;
    }
}

