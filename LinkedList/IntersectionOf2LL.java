package LinkedList;

public class IntersectionOf2LL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;

        while (d1 != null || d2 != null) {
            if (d1 == null) {
                d1 = headB;
            }
            if (d2 == null) {
                d2 = headA;
            }

            if (d1 == d2) {
                return d1;
            }

            d1 = d1.next;
            d2 = d2.next;
        }

        return null;
    }
}