package _0237;

class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("���������һ�����");
        }
        node.val = node.next.val;
        node.next = node.next.next;
        return;
    }
}

