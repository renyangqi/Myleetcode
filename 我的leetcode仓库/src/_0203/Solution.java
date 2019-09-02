package _0203;

class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode deleteNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                deleteNode = cur.next;
                cur.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}

