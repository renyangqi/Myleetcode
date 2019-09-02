package _0019;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        assert (n >= 0);
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            assert (q != null);
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode deleteNode = p.next;
        p.next = deleteNode.next;
        deleteNode = null;
        return dummyHead.next;
    }
}