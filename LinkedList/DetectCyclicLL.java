package LinkedList;

public class DetectCyclicLL  {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        } while (slow != fast);

        return true;
    }
}