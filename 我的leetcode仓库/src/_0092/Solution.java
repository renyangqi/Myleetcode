package _0092;

class Solution {
    public static ListNode reverseBetween(ListNode head, int m, int n) {// 1 2 3 4 5
        //要反转的链表的索引[m-1,n-1] 设最左边未left结点 右边为right结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode leftPre = dummyHead;//左结点的前一个结点
        ListNode left = dummyHead;
        ListNode right = dummyHead;
        ListNode rightNext = dummyHead;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        rightNext = right.next;
        right.next = null;
        for (int i = 0; i < m - 1; i++) {
            leftPre = leftPre.next;
        }
        left = leftPre.next;
        leftPre.next = null;
        ListNode ret = reverseList(left);
        leftPre.next = ret;
        ListNode retNext = ret;
        while (retNext.next != null) {
            retNext = retNext.next;
        }
        retNext.next = rightNext;
        return dummyHead.next;
    }
    public static ListNode reverseList(ListNode subhead) {
        ListNode pre = null;
        ListNode cur = subhead;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
/*public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;
        reverseBetween(a1, 1, 2);
    }*/

