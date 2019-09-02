package _0206;

public class Solution3 {
    public static ListNode reverseList(ListNode head) {
        // �ݹ���ֹ����
        if (head == null || head.next == null)
            return head;
        ListNode rhead = reverseList(head.next);
        //1->2->3->4->5
        // head->next�˿�ָ��head����������β�ڵ�
        // head->next->next = head��head�ڵ������β��
        head.next.next = head;
        head.next = null;
        return rhead;
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