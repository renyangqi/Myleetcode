package _0061;

import javax.swing.*;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int num = 1;
        ListNode cur = head;
        ListNode cur2 = head;
        while (cur.next != null) {
            cur = cur.next;
            num++;
        }
        cur.next = head;
        k = k % num;
        int iterToes = num - k - 1;


        for (int i = 0; i < iterToes; i++) {
            cur2 = cur2.next;
        }
        head = cur2.next;
        cur2.next = null;
        return head;
    }
}
