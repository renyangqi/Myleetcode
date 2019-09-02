package _0024;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node2.next = node1;
            p.next = node2;
            node1.next = node3;
            p = node1;
        }
        return dummyHead.next;

    }
}