package LinkedList;

public class RemoveNthFromBack {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode right = pre;
        ListNode left = pre;

        for (int i = 1; i<= n; i++) {
            right = right.next;
        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return pre.next;
    }
}