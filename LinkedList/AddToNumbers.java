package LinkedList;

public class AddToNumbers  {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode temp = start;
        int rem = 0;

        while (l1 != null || l2 != null || rem != 0) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            int sum = a + b + rem;
            temp.next = new ListNode(sum % 10);
            rem = sum/10;

            temp = temp.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return start.next;
    }
}