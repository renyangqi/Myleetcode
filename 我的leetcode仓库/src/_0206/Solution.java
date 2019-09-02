package _0206;

class Solution {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        System.out.println(1);
        return cur;
    }

    public static void main(String[] args) {
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
        ListNode listNode = reverseList(a1);
    }
}
